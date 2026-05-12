# VR market Growth Analyzer

Have you ever wondered how big the Virtual Reality (VR) world is actually getting? This project is a simple, interactive tool that looks at the VR industry's numbers 2022 to 2025 and uses them to predict where we’re headed. Whether you're curious about the market's value in 2030 or want to see when it might finally hit the **Trillion Dollar milestone**, this program does the math for you.

---

### **Features**
*   **History** Shows you a snapshot of where the market was just a few years ago.
*   **The "Crystal Ball"** Automatically calculates a 5-year projection for the year 2030.
*   **Pick Your Year:** An interactive tool where you can type in *any* year (up to 4000) and see the predicted growth.
*   **Smart Formatting** The program is smart enough to know when to talk in *Billions vs. *Trillions* so that the numbers actually make sense.

---

### **How the Math Works**
To keep things accurate, we used data trends similar to those found on professional analysis sites like [Statista's VR Market Report](https://www.statista.com/outlook/amo/ar-vr/worldwide). 

| Feature | Description |
| :--- | :--- |
| **Growth Formula** | `Base Value + (Base Value * Rate * Years)` |
| **User Heuristic** | 3 Million users for every $1 Billion in value |
| **Baseline Year** | 2025 |

---

### **Breakdown**
1.  **Initialize:** The `MarketAnalysis` object starts with baseline growth rates and values.
2.  **Display:** It prints out formatted headers and historical data from the internal array.
3.  **Interact:** The user enters a target year via the `UtilityBelt` (validated between 2020 and 4000).
4.  **Format** The system checks if the value is over 1,000 to decide between Billion or Trillion.

---

### **The Team**
Created by **Jonathan Smith**, **Zen Davis**, and **Prashanna Zhanka**.