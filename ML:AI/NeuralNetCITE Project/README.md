# 🌌 Kaggle Challenge 2: Abstract Neural Evolution for ADT Prediction

[![R](https://img.shields.io/badge/R-4.0+-blue)](https://www.r-project.org/)
[![PyTorch](https://img.shields.io/badge/PyTorch-1.9+-orange)](https://pytorch.org/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This project focuses on predicting **Antibody-Derived Tag (ADT)** expression profiles from RNA sequencing data using deep learning techniques. Developed as part of a Kaggle challenge, our approach leverages a **feedforward neural network** to capture complex, non-linear relationships between RNA and 25 ADT proteins, achieving a **0.872 Pearson correlation**—a significant improvement over a baseline multiple linear regression model (0.8022). The project explores various optimization strategies, including hyperparameter tuning with Bayesian optimization, to enhance model performance and generalization.

## 🎯 Objectives

- **Predict ADT Expression**: Accurately infer the expression of 25 ADT proteins from RNA sequencing data.
- **Optimize Neural Network**: Use advanced techniques like dropout, batch normalization, and Bayesian optimization to improve prediction accuracy.
- **Compare Approaches**: Benchmark the neural network against a traditional multiple linear regression model.
- **Ensure Generalization**: Balance model complexity to avoid overfitting while maintaining robust predictions.

## 📂 Project Structure

### Files
- **`Kaggle_Challenge_2_Draft.Rmd`**: R Markdown document detailing the project, including exploratory data analysis (EDA), model development, hyperparameter tuning, and results.
- **`Images/`**: Directory with visualizations (e.g., network diagrams, PCA plots).
- **`Project Files/`**: Directory with precomputed results (e.g., `slope_df.rds`, `batch_test_df_relu.rds`).
- **`Data/`**: Directory with datasets (`training_set_rna.csv`, `training_set_adt.csv`, `test_set_rna.csv`).

### Data
- **Training Data**:
  - `training_set_rna.csv`: 4,000 cells × 639 gene expression features.
  - `training_set_adt.csv`: 4,000 cells × 25 ADT proteins.
- **Test Data**:
  - `test_set_rna.csv`: 1,000 cells × 639 gene expression features (no ADT labels).

## 📊 Methodology

### Exploratory Data Analysis (EDA)
- **PCA Analysis**: Applied PCA to the RNA data (first 256 features) to identify patterns:
  - PC1 explained 63.99% of variance (std: 12.7993), indicating dominant expression patterns.
  - PC2 explained 3.43%, suggesting limited additional variance.
- **ADT Features**: Visualized the 25 ADT proteins (e.g., CD8a, CD4, CD3) to understand the response variables.
- **Insight**: Dense clustering in PCA suggests shared expression patterns, but feature reduction was not pursued due to strong model performance.

### Baseline Model: Multiple Linear Regression (MLR)
- **Approach**: Used matrix algebra to implement MLR:
  - Equation: \( \mathbf{ADT_{train}} = \mathbf{RNA_{train}} \times \hat{\mathbf{B}} \)
  - Solved for coefficients: \( \hat{\mathbf{B}} = (\mathbf{RNA_{train}}^T \mathbf{RNA_{train}})^{-1} \mathbf{RNA_{train}}^T \mathbf{ADT_{train}} \)
- **Performance**: Achieved a Pearson correlation of **0.8022** (R’s `lm()`: 0.80225).
- **Limitation**: Marginal improvement (1%) over `lm()`, prompting a shift to deep learning.

### Neural Network Development
- **Architecture**: A fully connected feedforward neural network with structures like 639→512→256→128→25 and 639→512→256→128→64→25.
- **Features**:
  - **Custom Activation Functions**: Primarily ReLU (outperformed sigmoid, softplus in tests).
  - **Dropout Regularization**: Applied with rates up to 0.5 to prevent overfitting.
  - **Batch Normalization**: Stabilized training (outperformed layer normalization).
  - **Mini-Batching**: Tested batch sizes from 32 to 256.
  - **ADAM Optimization**: Used with learning rate 0.001, fine-tuned \(\beta_1\) and \(\beta_2\).
  - **L2 Regularization**: Tested but reduced performance (increased loss, decreased Pearson correlation).
  - **Gradient Clipping**: Ensured training stability.
- **Implementation**: Initially built in R using a function-oriented approach (e.g., `forward_propagation`, `backward_propagation`), later transitioned to PyTorch for efficiency.

### Hyperparameter Tuning
- **Manual Tuning**:
  - **Learning Rate**: Tested 0.001 vs. 0.01; slower rates (0.001) performed better with higher dropout.
  - **Dropout Rate**: Optimal range 0.19–0.35; shallower networks favored mid-range dropout.
  - **Batch Size**: Tested 32 to 256; best performance at 48 (Pearson: 0.872), though 140 also showed promise.
  - **Activation Functions**: ReLU consistently outperformed sigmoid and softplus.
  - **Normalization**: Batch normalization outperformed layer normalization.
  - **ADAM Parameters**: Fine-tuned \(\beta_1\) and \(\beta_2\); default values were optimal.
- **Bayesian Optimization**:
  - Used `ParBayesianOptimization` with `bayesOpt()` to automate tuning.
  - Optimized learning rate (0.0001–0.01), dropout rate (0–0.5), batch size (32–256), and architecture.
  - Best result: Learning rate 0.0013, dropout 0.19, batch size 32, architecture 639→512→256→128→25 (iteration 51).

### Ensemble Models
- Trained multiple models and combined predictions via weighted averaging to improve robustness.

## 💡 Key Achievements

- **Performance**: Achieved a **0.872 Pearson correlation** on Kaggle, surpassing the baseline MLR (0.8022).
- **Model Selection**: Found shallower networks (e.g., 639→512→256→128→25) to be more consistent despite deeper networks achieving the highest score.
- **Optimization**: Bayesian optimization identified optimal hyperparameters, reducing manual tuning effort.
- **Generalization**: Balanced model complexity to avoid overfitting, validated by consistent validation metrics (e.g., R², MAE, RMSE).

## To View Project, click 'NeuralNetCITE.html' link above to download and view.
