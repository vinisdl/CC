#define GLFW_INCLUDE_GLU
#include <GLFW/glfw3.h>
#include <iostream>
#include <cmath>
#include <ctime>

const float Pi = 3.14159;

class Shape
{
public:
	Shape() {}
	~Shape() {}
	void DrawPeaple();
	void DrawPoligono(float lados);
	void DesenhaCirculo(GLenum gl, float circle_points, float angle, float raioX, float raioY, float x, float y);
	void DesenhaSemiCirculo(GLenum gl, float circle_points, float angle, float raioX, float raioY, float x, float y);

};

