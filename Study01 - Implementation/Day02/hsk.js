const fs = require("fs");
const stdin =
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `baa
a`;

const charMap = new Map();

for (let char of stdin) {
  if (char === " " || char === "\n") continue;

  if (charMap[char]) {
    charMap[char] += 1;
  } else {
    charMap[char] = 1;
  }
}

const charMapToArray = [...Object.entries(charMap)].sort((a, b) => b[1] - a[1]);
const maxCharCount = charMapToArray[0][1];
const maxChar = charMapToArray
  .filter(([char, count]) => count === maxCharCount)
  .map(([char, count]) => char)
  .sort()
  .join("");

console.log(maxChar);
