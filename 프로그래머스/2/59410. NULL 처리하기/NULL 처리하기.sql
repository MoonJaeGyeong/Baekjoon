-- 코드를 입력하세요
SELECT animal_type, 
COALESCE(name, 'No name') AS name, sex_upon_intake 
FROM animal_ins