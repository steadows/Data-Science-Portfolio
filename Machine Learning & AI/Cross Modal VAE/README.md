# Third Graduate Machine Learning Project Highlights

# 🧬 Third Graduate Machine Learning Project: Cross-Modal Variational Autoencoder

[![Python](https://img.shields.io/badge/Python-3.8+-blue)](https://www.python.org/)
[![PyTorch](https://img.shields.io/badge/PyTorch-1.9+-orange)](https://pytorch.org/)
[![PyTorch Lightning](https://img.shields.io/badge/PyTorch%20Lightning-1.5+-yellow)](https://www.pytorchlightning.ai/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This project, a collaborative effort with Lauryn Davis and Brooke Walters, focuses on a complex cross-modal learning challenge in single-cell sequencing data. We developed a **variational autoencoder (VAE)** with adversarial training to predict **ADT protein expression** from **RNA data** in unpaired single-cell datasets, addressing the lack of co-occurring samples across modalities. The project was evaluated on Kaggle, achieving a **0.75 Pearson correlation**, meeting the threshold for meaningful prediction in noisy biological data.

**Project Team**:
- Steve Meadows
- Lauryn Davis
- Brooke Walters

**Acknowledgments**: Special thanks to Zach DeBruine for guidance and support throughout the project.

## 🎯 Objectives

- **Cross-Modal Prediction**: Predict ADT (antibody-derived tags) profiles from RNA data in unpaired single-cell sequencing datasets.
- **Learn Shared Representations**: Create a modality-agnostic latent space capturing biological relationships between RNA and protein expression.
- **Optimize Performance**: Balance reconstruction accuracy (ADT Pearson correlation) and latent space integration using multi-objective optimization.

## 📂 Project Structure

### Files
- **`markdown_alternative.Rmd`**: R Markdown document detailing the project, including exploratory data analysis (EDA), VAE architecture, hyperparameter tuning, and results visualizations.
- **`images/`**: Directory containing static visualizations (e.g., histograms, TensorBoard screenshots, network diagrams).
- **`baseline_jsons/`**: JSON files with hyperparameter tuning results.
- **`Autoencoder Results Viz/`**: CSV files with training metrics for visualization.

### Data
The datasets include RNA and ADT profiles from dissociated tissue samples (e.g., blood):
- **Training Data**: `train_RNA.csv`, `train_ADT.csv`
- **Evaluation Data**: `eval_RNA.csv`, `eval_ADT.csv` (used for sanity checks)
- **Test Data**: `test_RNA.csv`

**Key Characteristics**:
- High sparsity (e.g., 45,635,260 zeros in RNA training data, 829 in ADT).
- RNA: Large feature set (gene expression).
- ADT: Smaller feature set (protein tags), with a sharper expression profile.

## 📊 Methodology

### Exploratory Data Analysis (EDA)
- **Histograms**: Visualized the distribution of log-normalized RNA and ADT values, highlighting sparsity and modality-specific patterns (e.g., RNA's smoother decay vs. ADT's sharp peak).
- **Insights**: The data's zero-inflation necessitated a VAE architecture capable of learning denoised representations.

### VAE Network Architecture
Built using **PyTorch** and **PyTorch Lightning**, the model adopts a modular, object-oriented approach:
- **Modality-Specific Encoders/Decoders**: `RNAEncoder`, `RNADecoder`, `ADTEncoder`, `ADTDecoder` capture modality-specific features.
- **Shared Latent Space**: `SharedEncoder` and `SharedDecoder` map inputs to a unified latent space with reparameterization.
- **Adversarial Training**: Incorporated discriminators (e.g., `LatentDiscriminator`) and a `GradientReversalFunction` to enforce modality-invariant features.
- **Stabilization Techniques**: Applied dropout, batch normalization, and layer normalization to prevent overfitting and stabilize training.

**Loss Function**:
- Reconstruction loss (MSE) + KL divergence for regularization.
- Adversarial loss to align latent spaces across modalities.

### Hyperparameter Tuning
- **Multi-Objective Bayesian Optimization**: Used Meta’s `Ax` (wrapper around `BoTorch`) to optimize:
  - ADT Pearson correlation (reconstruction accuracy).
  - Integration score (latent space alignment).
- **Key Findings**:
  - Lower batch sizes (65% correlation with higher ADT Pearson scores).
  - Smaller latent dimensions (71% correlation with better integration scores).
- **Pareto Frontier**: Identified four optimal solutions balancing both objectives.

### Training Enhancements
- **KL Divergence Annealing**: Used a logistic annealing schedule to balance reconstruction and regularization.
- **Wasserstein GAN with Gradient Penalty (WGAN-GP)**: Improved adversarial stability over traditional GANs.
- **Cosine Learning Rate Scheduling**: Enhanced convergence with dynamic learning rates.
- **L2 Regularization**: Applied to `mu` and `sigma` to prevent latent space collapse.
- **Optimizer**: AdamW with weight decay for better generalization.

### Monitoring and Visualization
- **TensorBoard**: Tracked training metrics, hyperparameter tuning (parallel coordinates plot), and latent embeddings (PCA, UMAP).
- **Shiny App**: Interactive visualizations of training metrics (e.g., KL divergence, loss, silhouette score).
- **UMAP Latent Embeddings**: Manually inspected to ensure cross-modal alignment and avoid latent space collapse.

## 💡 Key Achievements

- **Performance**: Achieved a **0.75 Pearson correlation** on Kaggle, meeting the threshold for meaningful prediction in noisy biological data.
- **Robust Architecture**: Balanced reconstruction accuracy and latent space integration through multi-objective optimization.
- **Dynamic Visualizations**: Leveraged TensorBoard and Shiny for real-time monitoring and post-analysis.
- **Stability**: Enhanced training stability with WGAN-GP, KL annealing, and regularization techniques.

## Links

Click Link to View Project: https://ldavis9997.shinyapps.io/Biological_VAE/
