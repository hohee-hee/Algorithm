function solution(n) {
    let answer = 0;
    let div = Math.floor(Math.sqrt(n));
    for(let i = 1 ; i <= div ; i++) {
        if(n % i === 0) {
            let tmp = n / i
            answer += i
            if(tmp !== i) answer += tmp
        }
    }
    return answer;
}