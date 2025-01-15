function solution(m, n, startX, startY, balls) {
    const sx = startX;
    const sy = startY;
    
    // 제곱함수
    const sq = num => num * num    
      
    const moveUp = (tx, ty) => sq(Math.abs(sx-tx)) + sq(n-sy+n-ty);
    const moveDown = (tx, ty) => sq(Math.abs(sx-tx)) + sq(sy+ty);
    const moveRight = (tx, ty) => sq(Math.abs(sy-ty)) + sq(m-sx+m-tx);
    const moveLeft = (tx, ty) => sq(Math.abs(sy-ty)) + sq(sx+tx);
       
    const answer = balls.map((ball,idx) => {
        const tx = ball[0];
        const ty = ball[1]
        if(sx === tx) {
            let min = Math.min(moveRight(tx, ty), moveLeft(tx, ty));
            if(sy > ty) {
                return Math.min(min, moveUp(tx, ty));
            } else {                
                return Math.min(min, moveDown(tx, ty));
            }
        } else if(sy === ty) {
            let min = Math.min(moveUp(tx, ty), moveDown(tx, ty));
            if(sx > tx) {
                return Math.min(min, moveRight(tx, ty));
            } else {                
                return Math.min(min, moveLeft(tx, ty));
            }
        } else {
            let xMin = Math.min(moveRight(tx, ty), moveLeft(tx, ty));
            let yMin = Math.min(moveUp(tx, ty), moveDown(tx, ty));
            return Math.min(xMin, yMin);
        }
    }); 
    
    return answer;
}
