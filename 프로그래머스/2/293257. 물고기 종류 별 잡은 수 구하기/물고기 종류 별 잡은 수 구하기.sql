SELECT COUNT(*) AS FISH_COUNT, (SELECT FISH_NAME FROM FISH_NAME_INFO N
                                WHERE I.FISH_TYPE = N.FISH_TYPE) AS FISH_NAME
FROM FISH_INFO I
GROUP BY FISH_TYPE
ORDER BY FISH_COUNT DESC