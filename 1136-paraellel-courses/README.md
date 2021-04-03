1136. Parallel Courses
Medium

329

12

Add to List

Share
You are given an integer n which indicates that we have n courses, labeled from 1 to n. You are also given an array relations where relations[i] = [a, b], representing a prerequisite relationship between course a and course b: course a has to be studied before course b.

In one semester, you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.

Return the minimum number of semesters needed to study all courses. If there is no way to study all the courses, return -1.



Example 1:


Input: n = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.
Example 2:


Input: n = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: No course can be studied because they depend on each other.


Constraints:

1 <= n <= 5000
1 <= relations.length <= 5000
1 <= a, b <= n
a != b
All the pairs [a, b] are unique.
