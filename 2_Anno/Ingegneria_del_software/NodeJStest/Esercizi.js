/** 
 * write a method that clears array from all unnecessitary elements, like false, undefined, empty strings, zero or null.
 * @param {Array} array - A generic array
 * @returns {Array}
*/

const compact = (array) => {
    return array.filter(value => value);
}

const randomarray = [1,2,"ciao","",null,undefined];
console.log(compact(randomarray));

/** 
 * Write a method that turns a deep array into a plain array
 * Ex: [1,2,[3,4,[5]]] -> [1,2,3,4,5]
 * @param {Array} array - A generic array
 * @returns {Array}
*/

const flatten = (array) => {
    return array.reduce((acc, val) => acc.concat(Array.isArray(val) ? flatten(val) : val),[]);
}

const nested = [1,2,[3,4,[5]]];
console.log(flatten(nested)); 