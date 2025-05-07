# 🥋 Brazilian Jiu Jitsu ADCC Analysis (Tableau)

[![Tableau](https://img.shields.io/badge/Tableau-2020+-blue)](https://www.tableau.com/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This project analyzes performance trends and submission techniques in **Brazilian Jiu Jitsu (BJJ)** competitions at the **Abu Dhabi Combat Club (ADCC)** tournaments using interactive **Tableau** dashboards. Leveraging two publicly available datasets, it provides visualizations to explore submission effectiveness, win rates, fighter performance, and global participation. Designed for competitive BJJ practitioners and coaches, the dashboards offer actionable insights to optimize training and understand high-level competition dynamics.

This work was submitted as a final paper for a course at Grand Valley State University, titled *"Global Illumination for Fun and Profit: Analyzing Techniques and Performance Trends in Brazilian Jiu Jitsu Competitions: A Visual Approach"*.

## 🎯 Objectives

The project addresses three key tasks:
1. **Identify Effective Submissions**: Analyze the most successful submission techniques across weight classes and time periods.
2. **Analyze Performance Trends**: Examine win rates, match outcomes, and fighter success metrics.
3. **Explore Global Fighter Distribution**: Investigate the relationship between fighter origins and submission specialization.

## 📂 Data Sources

- **ADCC Historical Dataset**: Contains match data, including submissions, outcomes, and timelines.
- **ADCC Fighter Stats**: Includes fighter details such as weight class and win rates.  
*Source*: Kaggle (publicly available datasets).

## 📊 Visualizations

The project features multiple interactive Tableau dashboards, as detailed in the accompanying PDFs (`241110_final_project_submissions_dashboard_1.pdf`, `241110_final_project_submissions_dashboard_2.pdf`, `241110_final_project_submissions_dashboard_3.pdf`):

### 1. Submissions by Weight Class
- **Purpose**: Highlight prevalent submissions and their success rates.
- **Components**:
  - **Pie Chart**: Displays the proportion of submissions (e.g., RNC, leg locks, arm locks) leading to victories.
  - **Line Chart**: Tracks submission trends (e.g., rise of leg locks) over time.
  - **Stacked Bar Chart**: Shows submission distribution by year and category (e.g., chokes, leg submissions, arm locks).
- **Insights**: Reveals the dominance of a few submission types and the increasing prevalence of leg locks in modern BJJ.

### 2. Rise of Leg Submissions
- **Purpose**: Visualize the growing importance of leg attacks.
- **Components**: Connected dot plot with a regression line showing the sum of leg submissions per ADCC competition year.
- **Insights**: Highlights a significant upward trend in leg submission usage, emphasizing the need for proficiency in leg attacks and defenses.

### 3. Submissions Per Year
- **Purpose**: Provide a detailed view of submission counts by year.
- **Components**: Horizontal bar chart aggregating submission types for each competition year.
- **Insights**: Enables year-to-year comparison of technique usage and trend identification.

### 4. Submission Categories by Year
- **Purpose**: Group submissions into categories (Chokes, Leg Submissions, Arm Locks, Other) for a generalized view.
- **Components**: Stacked bar chart showing the distribution of submission categories per year.
- **Insights**: Helps streamline offensive and defensive strategies based on category prominence.

### 5. Win Ratio by Country
- **Purpose**: Analyze fighter performance by country.
- **Components**: Visualization showing win ratios for fighters with 2 or more wins (mean win ratio = 1.7).
- **Insights**: Identifies countries with high-performing fighters and their competitive impact.

### 6. Top 20 Fighters by Win Ratio
- **Purpose**: Highlight the most successful fighters.
- **Components**: Chart ranking fighters by win ratio, with wins as a function of total fights.
- **Insights**: Reveals fighters with consistent success, aiding in opponent analysis.

### 7. Population Density of Fighters
- **Purpose**: Map the global distribution of ADCC fighters.
- **Components**: Density map with filters to explore fighter origins.
- **Insights**: Shows geographic hotspots for BJJ talent and potential regional submission specialization.

### 8. Submission Variety vs. Submission Win Ratio
- **Purpose**: Investigate the relationship between submission diversity and success.
- **Components**: Visualization comparing submission win ratios (standardized by z-scores) to the variety of submissions used by fighters.
- **Insights**: Fighters with fewer, specialized submissions tend to have higher win ratios, supporting a focused training approach.

### Interactive Filters
- **Sex Filter**: Toggle between male and female fighters.
- **Year Filter**: Focus on specific competition years.
- **Weight Class Filter**: Analyze trends within specific weight divisions.
- **Density Filter**: Adjust population density views for fighter distribution.
- **Purpose**: Enables customized analysis for tailored insights.

## 💡 Key Insights

- **Submission Dominance**: A small set of submissions (e.g., chokes, leg locks) account for most victories, challenging the need for a broad technique repertoire.
- **Fighter Success**: Fighters with fewer, highly refined submission types have higher win ratios, aligning with the principle of mastery over diversity.
- **Global Trends**: Certain countries produce disproportionately successful fighters, potentially linked to regional training styles.
- **Strategic Implications**: The rise of leg locks underscores the need for modern BJJ practitioners to prioritize leg attack and defense training.

## 🛠️ Setup and Installation

### Prerequisites
- **Tableau**: Tableau Desktop or Tableau Public (2020 or higher).
- **Datasets**: `ADCC_Historical.csv` and `ADCC_Fighter_Stats.csv` from Kaggle.

### Installation
1. Clone or download the project repository.
2. Place the datasets in the project directory.
3. Open the Tableau workbook (`.twb` or `.twbx`) in Tableau Desktop or Tableau Public.
4. Ensure the datasets are correctly linked to the workbook.

### Viewing Dashboards
- Open the Tableau workbook to interact with the dashboards.
- Use filters to customize views (e.g., by sex, year, or weight class).
- Alternatively, view static outputs in the provided PDFs (`241110_final_project_submissions_dashboard_1.pdf`, `241110_final_project_submissions_dashboard_2.pdf`, `241110_final_project_submissions_dashboard_3.pdf`).

## 📈 Usage

1. Launch Tableau and open the project workbook.
2. Navigate through the dashboards to explore submissions, fighter performance, and global trends.
3. Use interactive filters to tailor the analysis to specific needs (e.g., weight class or competition year).
4. Apply insights to inform training strategies or competition preparation.

## 📜 Example Output

- **Pie Chart**: Chokes (35%) and leg submissions (25%) dominate ADCC victories.
- **Line Chart**: Leg submissions increased 3x from 2000 to 2022.
- **Stacked Bar Chart**: Shows a shift from arm locks to leg submissions in recent years.
- **Win Ratio by Country**: Highlights countries with win ratios above the mean (1.7).
- **Submission Variety**: Fighters with 1-2 submission types have higher z-scored win ratios.

## 🌟 Personal Significance

As a BJJ practitioner, this project deepened my understanding of the sport’s competitive landscape. It reinforced the value of specialization, echoing Bruce Lee’s philosophy: *“I fear not the man who has practiced 10,000 kicks once, but I fear the man who has practiced one kick 10,000 times.”* The dashboards provide a practical tool for myself and others to refine training and strategy.

## 🔮 Future Improvements

- **Expanded Datasets**: Include match sequence data or real-time metrics.
- **Predictive Modeling**: Use machine learning to forecast match outcomes.
- **Web Deployment**: Publish dashboards on Tableau Public for broader access.
- **Additional Metrics**: Analyze positional control or submission attempt rates.

## 👤 Author

**Steve Meadows**  
Data Scientist | Brazilian Jiu Jitsu Practitioner  
Grand Valley State University  
GitHub: [@steadows](https://github.com/steadows/data-science-portfolio)  

## 📜 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use, modify, and share.

## 📚 Citation

If you use this project in your work, please cite:
> Meadows, S. (2025). *Analyzing Techniques and Performance Trends in Brazilian Jiu Jitsu Competitions: A Visual Approach*. Grand Valley State University.

---

*This Tableau project combines my passion for Brazilian Jiu Jitsu with data visualization, offering a data-driven edge for practitioners and coaches in a sport where details determine victory.*
