function solution(bandage, health, attacks) {
    let answer = health;
    let time = 0;
    
    for(const attack of attacks) {
        const recovery = (attack[0] - 1 - time) * bandage[1] + Math.floor((attack[0] - 1 - time) / bandage[0]) * bandage[2];
        answer = answer + recovery > health ? health : answer + recovery;
        answer = answer - attack[1] > 0 ? answer - attack[1] : -1;
        time = attack[0];
        if(answer === -1) break;
    }
    
    return answer;
}