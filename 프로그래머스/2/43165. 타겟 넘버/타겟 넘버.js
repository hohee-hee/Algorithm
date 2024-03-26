function solution(numbers, target) {    
    var answer = 0;
    
    const dfs = ((numbers, target, idx, val) => {
        if(idx === numbers.length) {
            val === target && answer++;
            return;
        }
        
        dfs(numbers, target, idx+1, val + numbers[idx]);
        dfs(numbers, target, idx+1, val - numbers[idx]);
    })
    
    dfs(numbers, target, 0, 0);
    return answer;
}
