const fs = require('fs');
const stdin = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString().trim()
    : `3
9
2 1 4 3 5 6 2 7 2`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const pictureCount = Number(input());
const totalRecommendedCount = Number(input());
const recommendedCandidates = input().split(' ').map(Number);
const candidates = [];

const sortByRules = (a, b) => {
  if (a.votes < b.votes) return -1;
  if (a.votes > b.votes) return 1;
  return a.date - b.date;
};

for (let i = 0; i < totalRecommendedCount; i++) {
  const recommendedCandidate = recommendedCandidates[i];
  const candidateIndex = candidates.findIndex(
    ({ candidate }) => candidate === recommendedCandidate
  );

  if (candidateIndex !== -1) {
    candidates[candidateIndex] = {
      ...candidates[candidateIndex],
      votes: candidates[candidateIndex].votes + 1,
    };
    continue;
  }

  if (candidates.length === pictureCount) {
    candidates.sort(sortByRules);
    candidates.shift();
  }

  candidates.push({ candidate: recommendedCandidate, votes: 1, date: i });
}

const finalCandidates = candidates
  .map(({ candidate }) => candidate)
  .sort((a, b) => a - b)
  .join(' ');
console.log(finalCandidates);
