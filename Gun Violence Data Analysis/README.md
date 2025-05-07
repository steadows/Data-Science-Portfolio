# Gun Violence Data Analysis

[![R](https://img.shields.io/badge/Built%20With-R-276DC3?logo=R&logoColor=white)](https://www.r-project.org/)
[![Markdown](https://img.shields.io/badge/Format-RMarkdown-lightgrey?logo=markdown&logoColor=black)](https://rmarkdown.rstudio.com/)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
![Status](https://img.shields.io/badge/status-Completed-brightgreen)
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## Overview
This project presents a comprehensive analysis of gun violence incidents in the United States using data from the Gun Violence Archive, covering the years 2014 through 2017. The analysis explores trends and patterns across various dimensions such as time, location (state and city level), and socioeconomic factors (e.g., poverty). It includes advanced visualizations, geospatial mapping, inferential statistics, and bootstrapping techniques to explore associations and test hypotheses about gun violence.

## Dataset
**Source:** [Gun Violence Archive via GitHub](https://github.com/jamesqo/gun-violence-data)

**Primary File:** `gunViolenceGeo.csv`

**Supplementary Datasets:**
- U.S. Census state-level data (2008–2021)
- U.S. Census county-level data (2009–2021)

These datasets were used to enrich the primary gun violence data with population and socioeconomic attributes for deeper contextual analysis.

## Key Technologies and Libraries
- **Format:** R Markdown (`.Rmd`, rendered with the `flatly` HTML theme)
- **Libraries:** `tidyverse`, `lubridate`, `plotly`, `leaflet`, `skimr`, `ggpubr`, `flextable`, `ggcorrplot`, `infer`, `sf`
- **Techniques:** Interactive visualization, geospatial mapping, permutation testing, bootstrapping, t-tests

## Analysis Pipeline
1. **Data Cleaning and Transformation**
   - Filtered out incomplete years (2013 and 2018)
   - Standardized date formats and extracted year/month
   - Resolved missing `geoid` values with state-city-year logic

2. **Missingness Exploration**
   - Used `naniar` to visualize and quantify missingness
   - Reduced missing `geoids` from 8,000+ to <500

3. **Exploratory Data Analysis (EDA)**
   - Trends by year and month
   - State-level per capita rates
   - Census population data integration

4. **Interactive Mapping**
   - Choropleth maps using `leaflet` and shapefiles for U.S. states

5. **City-Level Deep Dive**
   - Top cities by incident and death rates
   - Engineered features like rent %, home ownership, killed %, etc.
   - Correlation matrix across socioeconomic variables

6. **Statistical Inference**
   - Compared high- vs. low-poverty cities for death rates:
     - Welch’s t-test: p = 0.033
     - Permutation test: p = 0.011
     - Bootstrap 95% CI: [11.6, 48] deaths per 100k

## Insights
- Urban centers show disproportionate levels of gun violence.
- Per capita metrics highlight states/cities often overlooked in raw counts.
- Poverty shows statistically significant association with gun death rates.

## Conclusion
This project provides a data-driven foundation for understanding patterns of gun violence in the U.S., offering insight into how geographic and socioeconomic factors relate to violent incidents. While causality cannot be claimed, statistical evidence suggests poverty plays a role in gun violence outcomes.

**Next steps could include:**
- Incorporating gun ownership rates
- Evaluating policy impacts (e.g., carry laws)
- Analyzing police presence and response times

## Author
**Steve Meadows**  
Graduate Student – Data Science & Analytics  
📅 July 24, 2024

---

*All code was written in R using RMarkdown, with publicly available datasets from the Gun Violence Archive and U.S. Census Bureau. Please cite original sources if reusing this analysis.*
