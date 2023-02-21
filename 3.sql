SELECT `Month Number`,`Month Name`,`Year`,SUM(` Sales`)
AS Sales
FROM financialsample
GROUP BY `Month Number`,`Month Name`,`Year`
ORDER BY SUM(` Sales`) DESC
LIMIT 1