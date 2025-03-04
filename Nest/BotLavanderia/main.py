from typing import Final
from telegram import Message, Update
from telegram.ext import Application, CommandHandler, MessageHandler, filters, ContextTypes
import text_parser
import threading
import time
import asyncio

TOKEN: Final = '7125417961:AAF4ZpKqNokUtWzfctVnBB4tQJnjwAX64AI'
BOT_USERNAME: Final = '@Laundry_Nest_Bot'

global_array: list[tuple[str,str,int, Update]] = []

#Responses
async def handle_message(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    if update.message is None:
        return
    
    print(update.message.chat.username , update.message.text)
    tuplas: list[tuple[str, int, int]] = text_parser.parse(update.message.text)
    print(tuplas)
    for tupla in tuplas:
        create_timer(tupla, update.message.chat.username, update)

def create_timer(variables: tuple[str, int, int], nome: str, update: Update):
    total_seconds = 0
    if(variables[1] == None):
        total_seconds = variables[2]*60
    elif(variables[2] == None):
        total_seconds = variables[1]*3600
    else:
        total_seconds = variables[1]*3600 + variables[2]*60

    if (total_seconds >= 0):
        total_seconds+=time.time()
        tupla = [nome, variables[0], int(total_seconds), update]
        global_array.append(tupla)
        print("timer aggiunto per la lavatrice ", variables[0])
    else:
        print("timer inserito troppo lungo ", variables[0])

def countdown():
    for i in reversed(range(len(global_array))):
        if(time.time() >= global_array[i][2]):
            print(global_array[i][0], "la lavatrice", global_array[i][1], "ha finito")
            var=global_array[i][3].message
            if var is not None:
                asyncio.run(var.reply_text(f"@{global_array[i][0]} la lavatrice {global_array[i][1]} ha finito"))
                                
            del global_array[i]
        else:
            print("check lavatrice", global_array[i][1])

def polloing():
    app=Application.builder().token(TOKEN).build()

    #message handler
    app.add_handler(MessageHandler(filters.TEXT, handle_message))
    
    print("Polling...")
    app.run_polling(poll_interval = 3)

def time_management():
    while True:
        #time managment
        time.sleep(10)
        countdown()

if __name__ == "__main__":
    print("starting bot")

    t1 = threading.Thread(target=time_management, args=())
    t1.start()
    
    polloing()
    