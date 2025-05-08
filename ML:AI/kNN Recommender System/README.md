# 🐦 Kaggle Challenge One: Identifying Underrepresented Bird Species

[![R](https://img.shields.io/badge/R-4.0+-blue)](https://www.r-project.org/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This project, part of Kaggle Challenge One in Grand Valley’s CIS 678 Machine Learning course, focuses on identifying underrepresented bird species in the United States using data from [eBird](https://ebird.org/home), a citizen science platform. The dataset includes over 85 bird species, with observation counts ranging from 160,000 for common species to just 300 for rare ones. We implemented a **K-Nearest Neighbors (KNN)** algorithm to predict the presence of underrepresented species, achieving a final Kaggle MAE of **0.0357**, which is **25.3% below** the recommended threshold.

**Team Members (Team Elite)**:
- Lauryn Davis
- Steve Meadows
- Brooke Walters

**Evaluation Metric**: Mean Absolute Error (MAE) between predicted and actual species presence.

## 🎯 Objectives

- **Identify Underrepresented Species**: Predict the presence of less common bird species in eBird data.
- **Optimize KNN**: Tune hyperparameters (e.g., k, decay functions, soft zero weighting) to improve prediction accuracy.
- **Handle Data Sparsity**: Address the dataset’s high sparsity and variability in species counts.
- **Enhance Efficiency**: Use parallel processing to reduce computation time.

## 📂 Project Structure

### Files
- **`Kaggle_Challenge_1.Rmd`**: R Markdown document detailing the project, including exploratory analysis, algorithm implementation, hyperparameter tuning, and results.
- **`images/`**: Directory with visualizations (e.g., bird frequency plots, 3D MAE plots).
- **`combined_bird_totals.rds`, `bird_totals.rds`, etc.**: Precomputed data for analysis and visualizations.
- **`Test_Journal.xlsx`**: Spreadsheet with simulation results for hyperparameter tuning.
- **`submission.csv`**: Final Kaggle submission file.

### Data
- **Training Data**:
  - `training_set.csv`: Observation counts for 85 bird species across multiple checklists.
- **Test Data**:
  - `test_set.csv`: Test checklists for predicting species presence.
- **Key Characteristics**:
  - High sparsity (e.g., 81.7% zeros in training data, 81.5% in test data).
  - Wide range in species counts (e.g., Common Myna: 168,000+; rare species: ~300).

## 📊 Methodology

### Exploratory Analysis
- **Species Distribution**:
  - Top species (e.g., Common Myna) had over 168,000 observations.
  - Least common species had ~300 observations.
  - Mean count: 15,136; Median: 3,768; High variability (SD: 29,243).
- **Quintile Analysis**:
  - Divided species counts into quintiles (Q1–Q5).
  - Q5 (highest counts) showed the largest spread (SD: 46,086).
  - Q1 (lowest counts) had the smallest spread (SD: 225).
- **Sparsity**:
  - Training set: 81.7% zeros, 18.3% non-zeros.
  - Test set: 81.5% zeros, 18.5% non-zeros.
- **Insight**: High sparsity and variability suggested the need for Manhattan distance (robust to outliers) and data normalization.

### KNN Implementation
- **Algorithm**:
  - Used Manhattan distance as the primary metric, outperforming Euclidean and cosine distances.
  - Implemented exponential and triangular decay functions for neighbor weighting.
  - Added soft zero weighting to adjust the impact of missing values (zeros) in test columns.
- **Distance Functions**:
  - Manhattan distance: Sum of absolute differences between features.
  - Exponential decay: Weights decrease exponentially with distance (controlled by sigma).
  - Triangular decay: Linear weight decrease up to a radius (r), then zero.
- **Parallel Processing**:
  - Used `doParallel` and `parallelly` packages to reduce runtime from 10 minutes to 4 minutes.
  - Precomputed distances to optimize hyperparameter tuning.

### Hyperparameter Tuning
- **Initial Optimization**:
  - Tested k values (3–25) with Manhattan distance, no weighting: Optimal k = 19, MAE = 0.046.
  - Added exponential decay (sigma = 145.5): Reduced MAE to 0.0467.
  - Adjusted sigma to 10: Further reduced MAE to 0.046.
- **Soft Zero Weighting**:
  - Introduced a scalar (0–1) to reduce the impact of zeros in test columns.
  - Tested scalar (0.15–1) and sigma (5–50): Best result at scalar = 0.6, sigma = 10, MAE = 0.0447.
  - Refined range (scalar: 0.15–0.75, sigma: 5–12): Best at scalar = 0.4, sigma = 9, MAE = 0.0444.
- **Data Normalization**:
  - Applied log transformation (log(x + 1)) to reduce skewness.
  - Re-optimized k: Found k = 17 to be optimal.
  - Tested scalar (0.3–0.5) and sigma (7–9.75): Best at scalar = 0.25, sigma = 1.5, MAE = 0.0362.
- **Grid Search**:
  - Expanded search for k (3–71), scalar, and sigma.
  - Best result: k = higher values (e.g., 71), scalar = 0.25, sigma = 1.5, MAE = 0.0357.

## 💡 Key Achievements

- **Performance**: Achieved a final Kaggle MAE of **0.0357**, a 25.3% reduction below the recommended threshold.
- **Optimization**:
  - Manhattan distance outperformed other metrics due to sparsity handling.
  - Log transformation reduced skewness, improving MAE by 18.5% (from 0.0444 to 0.0362).
  - Soft zero weighting and exponential decay further reduced MAE by 3.04% (from 0.0362 to 0.0357).
- **Efficiency**: Parallel processing reduced runtime by 60% (10 minutes to 4 minutes).
- **Interpretability**: Identified key patterns in species distribution and data sparsity.

🔮 Future Improvements

Feature Engineering: Use K-means clustering to identify relationships between co-occurring or absent species.
Dimensionality Reduction: Apply PCA before clustering to focus on high-variance components.
Model Stacking: Combine KNN with clustering-based models to improve predictions.
Distance Metrics: Explore alternative metrics for K-means clustering (e.g., Euclidean distance) to enhance clustering quality.

👥 Authors

Steve Meadows
Lauryn Davis
Brooke Walters

📜 License
This project is licensed under the MIT License. Feel free to use, modify, and share.
🏷️ Tags
Machine Learning, Kaggle, KNN, Data Sparsity, Hyperparameter Tuning

This project uses KNN to identify underrepresented bird species, achieving a low MAE through careful optimization and parallel processing.

## To view project, click the 'kNN_Recommender_System_Birds.html' link above to download and view.
