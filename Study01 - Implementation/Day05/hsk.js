const fs = require('fs');
const [N, ...score] = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString().trim()
    : `6
10
20
15
25
10
20`
)
  .split('\n')
  .map(Number);

const stairs = new Array(N + 1).fill(0);

stairs[0] = score[0];
stairs[1] = Math.max(score[0] + score[1], score[1]);
stairs[2] = Math.max(score[1] + score[2], score[0] + score[2]);

for (let i = 3; i < N; i++) {
  stairs[i] = Math.max(score[i] + stairs[i - 2], score[i] + score[i - 1] + stairs[i - 3]);
}

console.log(stairs[N - 1]);
