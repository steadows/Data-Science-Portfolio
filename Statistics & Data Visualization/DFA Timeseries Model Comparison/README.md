# 📈 Order History DFA: Time Series Forecasting with Dynamic Factor Analysis

[![R](https://img.shields.io/badge/R-4.0+-blue)](https://www.r-project.org/)
[![Python](https://img.shields.io/badge/Python-3.8+-blue)](https://www.python.org/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This project, conducted during my data science internship, focuses on forecasting order volume using time series data by applying **Dynamic Factor Analysis (DFA)** to reduce dimensionality and capture latent trends. The original dataset included internal variables (e.g., order pipeline, price changes) and external variables (e.g., GDP, economic indicators), but due to confidentiality, I used a publicly available dataset, ["Bike Sales Data of 100k"](https://www.kaggle.com/datasets/jayavarman/bike-sales-data-of-100k), which mirrors the original timeframe and durable goods context. The DFA implementation was performed using the MARSS package in R, reducing the variables to six latent trends that explained 55% of the variance. These trends were then used in a prediction model (MSTL) to assess their impact on forecasting accuracy compared to the full dataset.

**Author**: Steve Meadows  
GitHub: [@SteveMeadows](https://github.com/steadows/data-science-portfolio)  

## 🎯 Objectives

- **Dimensionality Reduction**: Use DFA to simplify a multivariate time series dataset by identifying latent trends.
- **Interpret Trends**: Extract meaningful latent factors to better understand the drivers of order volume.
- **Evaluate Prediction Performance**: Compare forecasting accuracy using DFA-derived trends versus the full dataset.
- **Enhance Efficiency**: Assess the computational benefits of reduced dimensionality in time series forecasting.

## 📂 Project Structure

### Files
- **`dfa-performance-comparison.ipynb`**: Jupyter Notebook containing the prediction analysis using the public dataset, comparing MSTL model performance with DFA trends versus the full dataset.

### Data
- **Original Dataset (Confidential)**: Internal order history data with variables like order pipeline, price changes, GDP, and economic indicators.
- **Public Dataset (Proxy)**: ["Bike Sales Data of 100k"](https://www.kaggle.com/datasets/jayavarman/bike-sales-data-of-100k), containing 100,000 bike sales records from June 2022 to August 2024, aggregated to monthly sales for 27 months.
- **DFA Trends**: Six latent trends derived from the original dataset, used as exogenous variables in the prediction notebook.

## 📊 Methodology

### DFA Implementation (order_history_DFA.Rmd)
- **Data Preprocessing**:
  - Loaded the original dataset (`order_history.csv`) with 40 variables, excluding specific internal order metrics (e.g., `hm_net_orders`, `knoll_net_orders`).
  - Ensured stationarity by applying first and second differencing where necessary, using ADF and KPSS tests.
  - Standardized the data (z-scoring) as required by the MARSS package for DFA.
  - Removed redundant variables (e.g., multiple RTO variables, price increase data) to reduce overloading and improve interpretability.
- **DFA Modeling**:
  - Used the [MARSS package](https://cran.r-project.org/web/packages/MARSS/vignettes/UserGuide.pdf) to fit DFA models with 1 to 6 latent trends, selecting the optimal number based on AICc criteria.
  - Configured the model matrices with the following parameters:
    - Observation error matrix (R): Fixed as "diagonal and unequal," allowing each time series to have its own observation variance, which accounts for differing noise levels across variables.
    - Process error matrix (Q): Set to "diagonal and unequal," enabling each latent trend to evolve with its own variance, capturing distinct temporal dynamics.
    - State transition matrix (B): Defined as "identity," modeling the latent trends as independent random walks without interactions between trends.
    - Intercept matrix (A): Set to "zero," assuming no constant offset in the observation model.
    - Initial state mean (x0): Set to "zero," assuming the latent trends start at zero.
    - Initial state covariance (V0): Specified as a diagonal matrix with large values (10) for each trend, reflecting high uncertainty in the initial state.
  - Optimized the model using the BFGS method with a maximum of 10,000 iterations and a convergence tolerance of 1e-8 to ensure robust fitting.
  - Best model (m = 6, after adjustments) explained 55% of the variance with six trends, named based on high-loading variables: Unemployment Rate, Office Leasing, Vibes (sentiment), Interest Rates, BIFMA, and PROFCONS.
- **Rotation and Analysis**:
  - Applied Promax rotation to enhance interpretability of the latent trends.
  - Visualized trends and their correlations, and interpreted meaningful variable groupings.

### Prediction with Public Dataset (dfa-performance-comparison.ipynb)
- **Dataset Preparation**:
  - Used the "Bike Sales Data of 100k" dataset, aggregating sales to monthly totals (27 months, June 2022 to August 2024).
  - Integrated the six DFA-derived trends (V1–V6) as exogenous variables.
  - Split the data into training (21 months) and test (6 months) sets.
- **Forecasting Model**:
  - Implemented an MSTL (Multi-Seasonal Trend using Loess) model from the `statsforecast` library.
  - Trained the model using the training data with DFA trends as exogenous variables.
  - Forecasted the last 6 months and compared predictions to actual sales.
- **Performance Comparison**:
  - Evaluated the MSTL model with DFA trends versus the full dataset (not shown due to confidentiality).
  - Calculated Mean Absolute Error (MAE) and Root Mean Squared Error (RMSE) for the test period.

## 💡 Key Achievements

- **Dimensionality Reduction**: Reduced 40 variables to six latent trends using DFA, explaining 55% of the variance in the original dataset.
- **Interpretability**: Identified meaningful trends (e.g., Unemployment Rate, Interest Rates) that aligned with economic and business-specific factors.
- **Forecasting Performance**:
  - Using DFA trends with MSTL and MFLES on the public dataset yielded an MAE of 359,978.81 and RMSE of 403,447.51 over the 6-month test period.
  - On the original confidential dataset, DFA trends produced predictions nearly identical to the full dataset, demonstrating no loss in accuracy.
- **Efficiency Gains**: Reduced model complexity by using fewer features, highlighting DFA’s potential for scalability in high-dimensional time series forecasting.
