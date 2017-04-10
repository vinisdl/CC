#define GLFW_INCLUDE_GLU
#include <GLFW/glfw3.h>
#include <iostream>
#include <cmath>
#include <ctime>

const float Pi = 3.14159;
const float Xmin = 0;
const float Xmax = 10.0;
const float Ymin = 0;
const float Ymax = 10.0;
static float key = 0;
static float constant = 1;

class Shape
{
public:
	Shape() {}
	~Shape() {}
	void DrawPeaple();
	void DrawPoligono(float lados, bool equilatero, float con);
	void DrawLosango();
	void DesenhaCirculo(GLenum gl, float circle_points, float angle, float raioX, float raioY, float x, float y);
	void DesenhaSemiCirculo(GLenum gl, float circle_points, float angle, float raioX, float raioY, float x, float y);
	void DrawCirclePacman(GLenum gl, float circle_points, float angle, float raioX, float raioY, float x, float y);
	void DrawSpiral(float X, float Y);
	void DrawGrid();
};

