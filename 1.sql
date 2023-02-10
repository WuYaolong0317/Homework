SELECT Product, SUM(` Sales`) 
AS Sales
FROM financialsample
GROUP BY Product