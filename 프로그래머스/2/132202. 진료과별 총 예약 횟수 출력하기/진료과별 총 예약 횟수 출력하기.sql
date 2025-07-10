SELECT 
    mcdp_cd AS '진료과코드',
    COUNT(*) AS '5월예약건수'
FROM 
    appointment
WHERE 
    apnt_ymd >= '2022-05-01 00:00:00' AND apnt_ymd < '2022-06-01 00:00:00'
GROUP BY 
    mcdp_cd
ORDER BY 
    COUNT(*) ASC, mcdp_cd ASC;
