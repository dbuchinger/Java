This program determines whether or not a given point is contained in a triangle.
It does this by determining if the 3 lines of the triangle bound it in the positive
and negative x and y directions. A friend of mine was asked this question in an
interview and neither of us knew an easy way to solve it. It wasn't until I was most
of the way through my method that I realized that the point to be tested can be used
as the third point to form three separate triangles within the original triangle. All
that needs to be checked is whether or not the area of the three triangles formed with
the test point and the three combinations of two points from the original triangle is
equal to the area of the original triangle. If yes, the point is in the triangle and if
not, it's not. A quick google showed this was probably the expected solution, but I
finished mine anyway.