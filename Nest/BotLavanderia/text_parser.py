from __future__ import annotations

import re

from word2num import numbers


# Load resources
tokenizer = re.compile('[A-Za-z]+?(?=[ABCDEabcde])|[A-Za-z]+|\d+')

file = open("stopwords.txt", "r")
stopwords = file.read().splitlines()

stems = [
    ('lav', re.compile(r'lavatrice', re.IGNORECASE)),
    ('asc', re.compile(r'asciugatrice', re.IGNORECASE)),
    ('h', re.compile(r'or[ae]|hours?|hour', re.IGNORECASE)),
    ('m', re.compile(r'minuto|minuti|mins|min|mim', re.IGNORECASE))
]

expressions = [
    ('15 m', re.compile(r"un quarto d ora", re.IGNORECASE)),
    ('15', re.compile(r"un quarto", re.IGNORECASE)),
    ('30 m', re.compile(r"mezz ora", re.IGNORECASE)),
    ('30 m', re.compile(r"mezza", re.IGNORECASE)),
    ('45 m', re.compile(r"tre quarti d ora", re.IGNORECASE)),
    ('45 m', re.compile(r"tre quarti", re.IGNORECASE)),
]

# Preprocessing functions

def word_tokenizer(text: str):
    return tokenizer.findall(text)

def convert_expressions(text: str):
    for expr in expressions:
        text = expr[1].sub(expr[0], text)
    
    return text

def convert_numbers(tokens: list[str]):
    out = []

    for token in tokens:
        for num, regex in reversed(list(enumerate(numbers))):
            if regex.match(token):
                out.append(str(num))
                break
        else:
            out.append(token)
    
    return out

def filter_stopwords(tokens: list[str]):
    out = []

    for token in tokens:
        if token.casefold() not in stopwords and token not in 'aeio':
            out.append(token)
    
    return out

def stem_tokenizer(text: str):
    for stem in stems:
        text = stem[1].sub(stem[0], text)
    
    return text

# Parsing
id = r'(?P<id>((lav\ )?[ABCDE]\ ?)+)'           # lav A B C
time = r'''(?:
    (?P<h0>\d+)\ (h\ )?(?P<m0>\d+)(\ [m|h])?    # 10 30 | 10 h 30 | 10 30 m | 10 30 h | 10 h 30 m
    | (?P<h1>\d+)\ h                            # 10 h
    | (?P<m1>\d+)(\ m)?                         # 30 m | 30
)'''

re_parse = re.compile(fr'\b{id}\ {time}\b', re.VERBOSE)

def parse(text: str) -> list[tuple[str, int, int]]:
    out = []

    # Preprocessing
    tokens = word_tokenizer(text)
    string = convert_expressions(' '.join(tokens))
    tokens = convert_numbers(string.split())
    tokens = filter_stopwords(tokens)
    string = stem_tokenizer(' '.join(tokens))

    match = re_parse.finditer(string)
    for elem in match:
        id = elem['id']
        hours = elem['h0'] or elem['h1']
        minutes = elem['m0'] or elem['m1']

        if hours:
            hours = int(hours)
        
        if minutes:
            minutes = int(minutes)

        for wash_id in 'ABCDE':
            if wash_id in id:
                out.append((wash_id, hours, minutes))
    
    return out

for i in range(1):
    text = "auguro a voi e alle vostre famiglie la morte, sono 2 settimane che non pulite" #input('> ')
    print(parse(text))

#per usare il tutto chiama parse
#elimina il ciclo while in fondo
#aggiungi la cartella al file