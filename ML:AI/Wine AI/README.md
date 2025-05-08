# 🍷 Kaggle Challenge Four: Predicting Wine Tasting Notes from Climate Data

[![Python](https://img.shields.io/badge/Python-3.8+-blue)](https://www.python.org/)
[![PyTorch](https://img.shields.io/badge/PyTorch-1.9+-orange)](https://pytorch.org/)
[![LightGBM](https://img.shields.io/badge/LightGBM-3.0+-green)](https://lightgbm.readthedocs.io/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This project, part of Kaggle Challenge Four, aims to predict the probability of specific **tasting note keywords** in wine reviews using **climate data** and grape varietal information. We analyzed a dataset of over 10,000 wines across 64 varietals, incorporating daily climate data (minimum/maximum temperatures, rainfall, sunshine) from March 1 to November 1, 2022. The goal is to understand how environmental factors influence the sensory descriptors used in wine reviews, providing winemakers insights into how climate shapes wine perception and market reception.

**Team Members**:
- Lauryn Davis
- Steve Meadows
- Brooke Walters

**Evaluation Metric**: Mean Absolute Error (MAE) between predicted and true keyword probabilities.

## 🎯 Objectives

- **Predict Tasting Notes**: Model the likelihood of specific keywords (e.g., "fruity," "crisp") appearing in wine reviews.
- **Leverage Climate Data**: Use environmental factors and varietal information as predictors.
- **Enhance Interpretability**: Identify key climate features influencing tasting note language.
- **Optimize Performance**: Compare multiple models (FNN, LightGBM, Transformer) to achieve the lowest MAE.

## 📂 Project Structure

### Files
- **`Report.Rmd`**: R Markdown document detailing the project, including EDA, feature engineering, modeling, and results.
- **`images/`**: Directory with visualizations (e.g., scree plots, feature importance charts).
- **`project_files/`**: Directory with precomputed data (e.g., factor analysis results, feature importances).
- **`LGBM/data/`**: Directory with raw datasets (`climate_train.csv`, `climate_test.csv`, `words_train2.csv`).
- **`feature_engineering/feature_dataframes/`**: Directory with engineered feature CSVs.
- **`logs/`**: Directory with model logs and checkpoints.
- **Prediction Scripts**: Python scripts for generating Kaggle submissions (`predict_lgbm.py`, `predict_bert.py`).

### Data
- **Training Data**:
  - `climate_train.csv`: 9,802 wines × climate features (daily max/min temp, rain, sunshine).
  - `words_train2.csv`: 9,802 wines × 1,416 tasting note keyword probabilities.
- **Test Data**:
  - `climate_test.csv`: 1,001 wines × climate features.
- **Climate Features**: 4 modalities (max temp, min temp, rain, sunshine) over 245 days (March 1–November 1, 2022).

## 📊 Methodology

### Exploratory Data Analysis (EDA)
- **Dataset Summary**:
  - Training wines: 9,802
  - Test wines: 1,001
  - Unique tasting note keywords: 1,416
  - Climate days per modality: 245
- **Distribution Analysis**:
  - Visualized distributions of climate modalities (max temp, min temp, rain, sunshine) before and after normalization.
  - Transformations: Standard scaling for temperatures, log transform for rain and sunshine.
  - Result: Highlighted skewness (e.g., high zero-inflation in rain) and modality-specific patterns.

### Feature Engineering
- **Daily Climate Features**: Raw daily measurements (e.g., max temp, rain).
- **Varietal Features**: Integer encoding of varietals for embedding.
- **Moving Averages**: 7/14/30-day averages for each modality.
- **Engineered Features**: Indicators (e.g., rainfall type, desert conditions), counts (e.g., rainy days), seasonal averages, and interaction terms (e.g., rain × max temp interaction).
- **Word-Cluster Features**:
  - KMeans clustering (9 clusters) on tasting note probabilities.
  - Cluster probabilities averaged by varietal.
- **DistilBERT Features**:
  - Generated pseudo-texts from top 10 words per varietal.
  - Used DistilBERT to create 768D embeddings, reduced to 5 PCA components.
- **Feature Importance**:
  - Used mutual information regression to identify key features.
  - Reduced feature set from 33 to 21 (90% importance threshold), improving MAE by 9% (0.022 to 0.020).

### Modeling
#### Feedforward Neural Network (FNN)
- **Architecture**: Two hidden layers (512, 256 units), LayerNorm, ReLU, 45% dropout, sigmoid output.
- **Training**:
  - Focal loss to handle label sparsity (~80% zeros).
  - L1 sparsity penalty on predictions.
  - Hyperparameter tuning via randomized grid search.
  - Five-fold cross-validation.
- **Metrics**: Validation MAE, F1, mean probability.
- **Result**: Underperformed compared to advanced models but provided interpretable insights via SHAP.

#### LightGBM (Climate-Only Model)
- **Approach**:
  - Used Tweedie loss, suitable for skewed distributions with many zeros.
  - KMeans clustering on words (30, 60, 90 clusters) for multi-resolution modeling.
  - Post-prediction sparsity thresholding.
- **Performance**: MAE of **0.02541** on Kaggle.
- **Top Features**:
  - `num_rainy_days`, `spring_rain_avg`, `maxtemp_ma_30`.

#### LightGBM (Climate + Word Features)
- **Approach**:
  - Added DistilBERT PCA embeddings, word entropy, and top word ratios (per wine).
  - Reduced embeddings to 20 PCA components.
  - Same multi-resolution clustering (40, 80, 110 clusters).
- **Performance**: MAE of **0.02061** on Kaggle.
- **Top Features**:
  - `word_entropy`, `word_cluster_8_prob` (Red Fruit & Spicy), `word_cluster_4_prob` (Citrus & Mineral).

#### ClimateEncoderTransformer (PyTorch Transformer)
- **Architecture**:
  - Transformer encoder (5 layers, 8 heads, `d_model=128`).
  - Varietal and climate embeddings, learned positional embeddings.
  - GELU activation, dropout (attention: 0.15, climate: 0.15, varietal: 0.15).
- **Training**:
  - MAE loss with mean penalty (`lambda_mean`).
  - AdamW optimizer, ReduceLROnPlateau scheduler.
  - Hyperparameter tuning using Ax with BoTorch (100 trials).
- **Performance**: MAE of **0.01873** on Kaggle (best model).
- **Best Hyperparameters**:
  - Learning Rate: 2e-4
  - Batch Size: 4
  - `d_model`: 256
  - `num_layers`: 3

## 💡 Key Achievements

- **Performance**: Achieved a best MAE of **0.01873** on Kaggle with the Transformer model, followed by LightGBM (Climate + Word Features) at **0.02061**, and LightGBM (Climate-Only) at **0.02541**.
- **Interpretability**:
  - Identified key climate features (e.g., `num_rainy_days`, `spring_rain_avg`) influencing tasting notes.
  - Word clusters revealed semantic patterns (e.g., "Red Fruit & Spicy," "Citrus & Mineral").
- **Feature Engineering**: DistilBERT embeddings and factor analysis provided semantic insights into varietal differences.
- **Model Diversity**: Compared FNN, LightGBM, and Transformer models, balancing performance and interpretability.

🔮 Future Improvements

Feature Expansion: Incorporate additional climate metrics (e.g., humidity, wind).
Ensemble Models: Combine predictions from LightGBM and Transformer for better performance.
Advanced Clustering: Explore hierarchical clustering for word features.
Dynamic Thresholding: Implement adaptive sparsity thresholds for test predictions.

👥 Authors

Steve Meadows
Lauryn Davis
Brooke Walters

📜 License
This project is licensed under the MIT License. Feel free to use, modify, and share.
🏷️ Tags
Machine Learning, Kaggle, Bioinformatics, Deep Learning, Feature Engineering

This project leverages machine learning to connect climate data with wine tasting notes, providing actionable insights for winemakers through advanced modeling and feature engineering.

## To view project, click the 'WineAI.html' link above to download and view
