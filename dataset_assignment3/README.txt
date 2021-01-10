Format of data files:

- Line #1: Number of start positions, N.
- Line #2: Number of end positions, M.
- N next lines: coordinates (column, row) of N start positions.
- M next lines: coordinates (column, row) of M end positions.
- Column indices are from 1 to 25 and from left to right. Row indices are from 1 to 25 and from bottom to top. 
- After above line is the matrix of the race track of 25x25 bits, where each 0 bit represents a gridpoint inside the track, each 1 bit represents a grid point outside the track.

