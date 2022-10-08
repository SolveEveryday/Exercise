const fs = require('fs');
const [N, ...words] = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString().trim()
    : `5
ab
aa
aca
ba
bb
`
).split('\n');

let notGroupWordCount = 0;

words.forEach((word) => {
  let temp = '';
  let removedRepeatWord = '';
  for (const char of word) {
    if (temp === char) continue;

    temp = char;
    removedRepeatWord += char;
  }

  const checkedWord = new Set();
  for (const char of removedRepeatWord) {
    if (checkedWord.has(char)) {
      notGroupWordCount += 1;
      break;
    } else {
      checkedWord.add(char);
    }
  }
});

console.log(N - notGroupWordCount);
