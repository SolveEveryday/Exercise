/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
  const absStr = Math.abs(x).toString();
  const reversedStr = absStr.split('').reverse().join('');

  const number = Number(reversedStr);

  if (number < Math.pow(-2, 31) || number > Math.pow(2, 31) - 1) {
    return 0;
  }

  return x > 0 ? number : -number;
};

console.log(reverse(123));
console.log(reverse(-123));
console.log(reverse(120));
console.log(reverse(1534236469));
