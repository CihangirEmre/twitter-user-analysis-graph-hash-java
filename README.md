# X (Twitter) Data Analysis and User Interest Matching

This project was developed for Kocaeli University Programming Laboratory I (Project 3).

The goal is to analyze user data collected from a Twitter-like dataset and create user-to-user relationships based on shared interests. Users are stored using custom hash tables, and follower/following relations are modeled as a graph for further analysis.

## Key Requirements (Course Spec)

- User data is obtained via Twitter API / JSON (no database is used).
- Each user is represented as an object (username, name-surname, follower/following counts, language, region, tweets, followers, followings).
- Users are organized using hash tables.
- Relationships are modeled as a graph (nodes: users, edges: follower/following).
- Interest matching and graph analysis are performed using algorithms such as hashing/search, DFS, BFS, and MST.
- Analysis results are exported to text files.

## Implementation Summary

- Data generation: synthetic user data created for testing.
- Parsing: JSON data is read using Gson.
- Custom data structures:
  - Hash table implementation (`myHashMap`)
  - Doubly linked list (`myDoubleLinkedList`)
  - Graph model (`GraphModel`, `GraphVertex`)
- Interest extraction: interests are derived from tweet words and aggregated per user.
- Reporting: outputs and analysis summaries are written to text files.

## Repository Structure

- `src/`: Java source code
- `data/`: sample JSON inputs used for testing
- `outputs/`: generated analysis reports
- `docs/`: project specification and the final report

## Report

The project report is available under:
- `Prolab3_Report.pdf`

