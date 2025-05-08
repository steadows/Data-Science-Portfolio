# 🧠 ML/AI Portfolio

[![Python](https://img.shields.io/badge/Python-3.8+-blue)](https://www.python.org/)
[![R](https://img.shields.io/badge/R-4.0+-blue)](https://www.r-project.org/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This folder showcases my machine learning and AI projects, demonstrating my ability to tackle diverse challenges in bioinformatics, environmental science, and predictive modeling. These projects were completed as part of Kaggle Challenges during my coursework in Grand Valley’s CIS 678 Machine Learning course. Our team took 1st place for projects 1 & 2, and 2nd place for projects 3 and 4. I collaborated with Lauryn Davis and Brooke Walters on all projects, leveraging advanced algorithms, feature engineering, and optimization techniques to achieve strong results. Below is a summary of each project, with links to their respective directories for detailed insights.

**Author**: Steve Meadows  
GitHub: [@steadows](https://github.com/steadows/data-science-portfolio)  

**Collaborators**: Lauryn Davis, Brooke Walters

## 📂 Projects

### 1. Kaggle Challenge One: Identifying Underrepresented Bird Species 🐦
- **Objective**: Predict the presence of underrepresented bird species in eBird citizen science data using a K-Nearest Neighbors (KNN) algorithm.
- **Key Achievements**:
  - Achieved a Kaggle MAE of 0.0357, 25.3% below the recommended threshold.
  - Optimized KNN with Manhattan distance, log transformation, exponential decay (sigma = 1.5), and soft zero weighting (scalar = 0.25).
  - Reduced runtime by 60% (from 10 to 4 minutes) using parallel processing with `doParallel`.
- **Technologies**: R, `doParallel`, `tidyverse`, `plotly`.
- **Directory**: [kNN Recommender System/](https://github.com/steadows/Data-Science-Portfolio/tree/main/ML%3AAI/kNN%20Recommender%20System)
- **Link**: [kNN_Recommender_System_Birds.html](https://github.com/steadows/Data-Science-Portfolio/blob/main/ML%3AAI/kNN%20Recommender%20System/kNN_Recommender_System_Birds.html)

### 2. Kaggle Challenge Two: Abstract Neural Evolution for ADT Prediction 🧬
- **Objective**: Predict Antibody-Derived Tag (ADT) expression from RNA sequencing data using a feedforward neural network (FNN).
- **Key Achievements**:
  - Achieved a Kaggle Pearson correlation of 0.872, surpassing the baseline multiple linear regression model (0.8022).
  - Used Bayesian optimization (`ParBayesianOptimization`) to tune hyperparameters, achieving optimal settings (e.g., learning rate = 0.0013, dropout = 0.19).
  - Balanced model complexity with techniques like dropout (0.19–0.35), batch normalization, and ensemble modeling.
- **Technologies**: R, PyTorch, `tidyverse`, `plotly`.
- **Directory**: [NeuralNetCITE Project/](https://github.com/steadows/Data-Science-Portfolio/tree/main/ML%3AAI/NeuralNetCITE%20Project)
- **Link**: [NeuralNetCITE.html](https://github.com/steadows/Data-Science-Portfolio/blob/main/ML%3AAI/NeuralNetCITE%20Project/NeuralNetCITE.html)

### 3. Third Graduate Machine Learning Project: Cross-Modal Variational Autoencoder 🧬
- **Objective**: Predict ADT protein expression from RNA data in unpaired single-cell sequencing datasets using a variational autoencoder (VAE) with adversarial training.
- **Key Achievements**:
  - Achieved a Kaggle Pearson correlation of 0.75, meeting the threshold for meaningful prediction in noisy biological data.
  - Developed a robust VAE architecture with modality-specific encoders/decoders and a shared latent space, enhanced by Wasserstein GAN with Gradient Penalty (WGAN-GP).
  - Utilized multi-objective Bayesian optimization (via Meta’s `Ax`) to balance reconstruction accuracy and latent space integration.
- **Technologies**: Python, PyTorch, PyTorch Lightning, `shiny` (for interactive visualizations).
- **Directory**: [Cross_Modal_VAE/](Cross_Modal_VAE/)
- **Link**: [Cross_Modal_VAE](https://ldavis9997.shinyapps.io/Biological_VAE/)

### 4. Kaggle Challenge Four: Predicting Wine Tasting Notes from Climate Data 🍷
- **Objective**: Predict the probability of tasting note keywords in wine reviews using climate data and varietal information.
- **Key Achievements**:
  - Achieved a best Kaggle MAE of 0.01873 with a Transformer model (ClimateEncoderTransformer), outperforming LightGBM models (MAEs of 0.02541 and 0.02061).
  - Engineered features using DistilBERT embeddings and KMeans clustering, identifying key predictors like `num_rainy_days` and `word_entropy`.
  - Tuned the Transformer model with Ax and BoTorch, optimizing hyperparameters (e.g., learning rate = 2e-4, `d_model` = 256).
- **Technologies**: Python, PyTorch, LightGBM, `transformers`, `sklearn`.
- **Directory**: [Wine AI/](https://github.com/steadows/Data-Science-Portfolio/tree/main/ML%3AAI/Wine%20AI)
- **Link**: [WineAI.html](https://github.com/steadows/Data-Science-Portfolio/blob/main/ML%3AAI/Wine%20AI/WineAI.html)

## 💡 Key Skills Demonstrated

- **Algorithm Development**: Implemented and optimized diverse models including KNN, FNN, VAE, LightGBM, and Transformer architectures.
- **Feature Engineering**: Engineered features using PCA, KMeans clustering, DistilBERT embeddings, and domain-specific insights (e.g., climate interactions, biological data sparsity).
- **Hyperparameter Tuning**: Employed advanced optimization techniques like Bayesian optimization (`ParBayesianOptimization`, Ax/BoTorch) to achieve optimal model performance.
- **Efficiency**: Leveraged parallel processing to reduce computation time (e.g., 60% runtime reduction in KNN project).
- **Interpretability**: Used visualization tools (TensorBoard, Shiny, Plotly) and feature importance analysis to provide actionable insights.
- **Collaboration**: Worked effectively in a team to design, implement, and evaluate solutions across all projects.

## 📜 License

All projects are licensed under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use, modify, and share.

## 🏷️ Tags

Machine Learning, Deep Learning, Kaggle, Bioinformatics, Feature Engineering, Hyperparameter Tuning

---

*This portfolio highlights my expertise in machine learning and AI, showcasing projects that solve complex problems with innovative techniques and strong results.*
