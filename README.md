
# PlanetfanCalculator

PlanetfanCalculator is a project developed for the internal needs of the Planetfan (https://planetfan.pl/) company. This calculator has been designed to assist Planetfan's engineers, architects, and contractors in converting values related to fans, densities, noise, flow, and engine power.

The calculator simplifies the conversion process, making it quicker and more efficient for the team to work with. By providing accurate results, Planetfan can optimize their ventilation systems and deliver the best possible solutions to their clients.

More screens at the end.
![Screenshot 2023-04-17 184851.png](assets/Screenshot%202023-04-17%20184851.png)

## Tech Stack

**Client:** Java, JavaFx


## Features

- Scaling fan parameters
- Calculating air density by three methods
- Acoustic calculations:
    - Acoustic power
    - Sound level at a point
    - Variation of acoustic pressure with distance. Point source
    - Variation of acoustic pressure with distance. Line source
    - Correction of acoustic power based on diameter
    - Correction of acoustic power based on speed
    - Correction of acoustic power based on the number of sources
    - Circumferential velocity
    - Calculation of distance from the source
- Calculating mass of different types elements in construct engineering
- Calculating flow efficiency
- Calculating electricity power of motor by known current



## Latest Changes

- -> Adding an auxiliary drawing in the Acoustics tab 
- -> Acoustic Power
- -> Adding icons
- -> Changing the input unit in the Air Density tab 
- -> Relative Humidity (from dimensionless coefficient to percentage)
- -> Verification of calculations on the cards
- -> The Fan Similarity Card calculates values according to the formulas:

            Qk = Q1 * nk / n1 * Math.pow(Dk/D1, 3);
            dPk = dP1 * rok / ro1 * Math.pow(Dk/D1, 2) * Math.pow(nk/n1, 2);
            Nk = rok / ro1 * Math.pow(Dk/D1, 5) * Math.pow(nk/n1, 3) * N1;
            eta = Q1 * dP1 / N1 * 100 / 1000;
            U = Math.PI * Dk * nk / 60;
            omega = 2 * Math.PI * nk / 60;
            Ak = Math.PI * Math.pow(Dk, 2) / 4;
            c = Qk / Ak;
            Pd = rok * Math.pow(c, 2) / 2;

            double fi = Q1 / (Math.PI / 4 * Math.pow(D1, 2) * (Math.PI * D1 * n1 / 60));
            double psi = dP1 / (0.5 * ro1 * Math.pow(Math.PI * D1 * n1 / 60, 2));



## Authors

- [@tomdud-developer](https://www.github.com/tomdud-developer)

## Logo
![Logo](assets/logo.ico)

## Screenshots
![Screenshot 2023-04-17 184851.png](assets/Screenshot%202023-04-17%20184851.png)
![Screenshot 2023-04-17 184856.png](assets/Screenshot%202023-04-17%20184856.png)
![Screenshot 2023-04-17 184900.png](assets/Screenshot%202023-04-17%20184900.png)
![Screenshot 2023-04-17 184903.png](assets/Screenshot%202023-04-17%20184903.png)
![Screenshot 2023-04-17 184913.png](assets/Screenshot%202023-04-17%20184913.png)
![Screenshot 2023-04-17 184917.png](assets/Screenshot%202023-04-17%20184917.png)
![Screenshot 2023-04-17 184922.png](assets/Screenshot%202023-04-17%20184922.png)
![Screenshot 2023-04-17 184926.png](assets/Screenshot%202023-04-17%20184926.png)
![Screenshot 2023-04-17 184928.png](assets/Screenshot%202023-04-17%20184928.png)

