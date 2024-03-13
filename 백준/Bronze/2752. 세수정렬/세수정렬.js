const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath).toString().trim().split(" ");

input.sort((a, b) => a - b);

input.forEach((element) => {
  process.stdout.write(element + " ");
});
