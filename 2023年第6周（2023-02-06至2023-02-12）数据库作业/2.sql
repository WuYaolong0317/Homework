SELECT Country, SUM(` Sales`)
AS Sales
FROM financialsample
GROUP BY Country 
ORDER BY SUM(` Sales`) DESC