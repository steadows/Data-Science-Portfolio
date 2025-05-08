# 📊 Statistics & Data Visualization Portfolio

[![R](https://img.shields.io/badge/R-4.0+-blue)](https://www.r-project.org/)
[![Python](https://img.shields.io/badge/Python-3.8+-blue)](https://www.python.org/)
[![Tableau](https://img.shields.io/badge/Tableau-2020+-blue)](https://www.tableau.com/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This folder showcases my projects in statistics and data visualization, highlighting my ability to extract insights from complex datasets and present them through compelling visualizations and rigorous statistical analysis. These projects span diverse domains, including sports analytics, social issues, and business forecasting, demonstrating my versatility in applying statistical methods and visualization tools to real-world problems. Below is a summary of each project, with links to their respective directories for detailed insights.

**Author**: Steve Meadows  
GitHub: [@SteveMeadows](https://github.com/steadows/data-science-portfolio)  

## 📂 Projects

### 1. Brazilian Jiu Jitsu ADCC Analysis (Tableau) 🥋
- **Objective**: Analyze performance trends and submission techniques in Brazilian Jiu Jitsu (BJJ) at Abu Dhabi Combat Club (ADCC) tournaments using interactive Tableau dashboards.
- **Key Achievements**:
  - Identified dominant submissions (e.g., chokes, leg locks) and their trends over time, highlighting the rise of leg attacks.
  - Revealed that fighters with specialized submissions (fewer techniques) had higher win ratios, supporting focused training strategies.
  - Mapped global fighter distribution, showing regional hotspots and potential submission specializations.
- **Technologies**: Tableau, R (data preprocessing).
- **Directory**: [Brazilian Jiu Jitsu ADCC Analysis/](https://github.com/steadows/Data-Science-Portfolio/tree/main/Statistics%20%26%20Data%20Visualization/Brazilian%20Jiu%20Jitsu%20ADCC%20Analysis)

### 2. Gun Violence Data Analysis 🔫
- **Objective**: Explore trends and patterns in U.S. gun violence incidents (2014–2017) using geospatial mapping, interactive visualizations, and statistical inference.
- **Key Achievements**:
  - Demonstrated urban centers as hotspots for gun violence, with per capita metrics revealing overlooked states/cities.
  - Found a statistically significant association between poverty and gun death rates (Welch’s t-test: p = 0.033, permutation test: p = 0.011).
  - Used bootstrapping to estimate a 95% confidence interval for death rates in high-poverty cities: [11.6, 48] deaths per 100k.
- **Technologies**: R, `tidyverse`, `leaflet`, `plotly`, `infer`.
- **Directory**: [Gun Violence Data Analysis/](https://github.com/steadows/Data-Science-Portfolio/tree/main/Statistics%20%26%20Data%20Visualization/Gun%20Violence%20Data%20Analysis)

### 3. Order History DFA: Time Series Forecasting with Dynamic Factor Analysis 📈
- **Objective**: Forecast order volume using Dynamic Factor Analysis (DFA) to reduce dimensionality and capture latent trends in a multivariate time series dataset.
- **Key Achievements**:
  - Reduced 40 variables to six latent trends using DFA, explaining 55% of the variance in the original dataset.
  - Achieved an MAE of 359,978.81 and RMSE of 403,447.51 over a 6-month test period using DFA trends with an MSTL model on a public dataset.
  - Demonstrated that DFA trends produced predictions nearly identical to the full dataset, highlighting efficiency gains without loss of accuracy.
- **Technologies**: R (`MARSS`), Python (`statsforecast`, `pandas`), Jupyter Notebook.
- **Directory**: [DFA Timeseries Model Comparison/](https://github.com/steadows/Data-Science-Portfolio/tree/main/Statistics%20%26%20Data%20Visualization/DFA%20Timeseries%20Model%20Comparison)

## 💡 Key Skills Demonstrated

- **Statistical Analysis**: Applied inferential statistics (t-tests, permutation tests, bootstrapping) and time series modeling (DFA) to derive actionable insights.
- **Data Visualization**: Created interactive dashboards with Tableau, geospatial maps with `leaflet`, and trend visualizations with `ggplot2` and `matplotlib`.
- **Data Preprocessing**: Handled missing data, ensured stationarity in time series, and integrated supplementary datasets for enriched analysis.
- **Tool Proficiency**: Leveraged R and Python for statistical modeling, visualization, and forecasting, alongside Tableau for interactive reporting.
- **Domain Application**: Addressed diverse challenges in sports, social issues, and business forecasting, tailoring analyses to specific audiences (e.g., BJJ practitioners, policymakers, business stakeholders).

## 📜 License

All projects are licensed under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use, modify, and share.

## 🏷️ Tags

Statistics, Data Visualization, Time Series, Geospatial Analysis, Interactive Dashboards

---

*This portfolio highlights my expertise in statistics and data visualization, showcasing projects that blend rigorous analysis with impactful visualizations to drive insights across diverse domains.*
