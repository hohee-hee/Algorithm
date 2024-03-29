function solution(n) {
    var answer = 0;
    const max = Math.floor(Math.sqrt(n));
    for(let i = 1 ; i <= n ; i++) {
        if(n % i === 1) return i;
    }
    return answer;
}