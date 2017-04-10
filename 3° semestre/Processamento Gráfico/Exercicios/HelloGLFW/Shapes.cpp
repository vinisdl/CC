#include "Shapes.h"

void Shape::DrawPoligono(float lados, bool equilatero, float con) {

	glColor3f(0, 0, 0);
	glBegin(GL_LINE_LOOP);

	int i = 0;
	float x, y;
	float t = 0.81;
	float radius = 2;
	float angle_increment = (float)2 * Pi / lados;

	while (i < lados)
	{
		t = t + angle_increment;
		x = (sin(t)*radius);
		y = (cos(t)*radius);
		if (!equilatero && (i == 3 || i == 2))
			glVertex2f(x + 3, y + 3 + con);
		else
			glVertex2f(x + 3, y + 3);

		i++;
	}
	glEnd();
}

void Shape::DrawLosango() {
	glColor3f(0, 0, 0);
	glBegin(GL_LINE_LOOP);
	glVertex2f(3, 3);
	glVertex2f(3.5, 4);
	glVertex2f(3, 5);
	glVertex2f(2.5, 4);
	glEnd();
}




void Shape::DrawGrid()
{
	glLineWidth(1);

	float xi = Xmin;
	float yi = Ymin;
	float ncells = 20.0;

	float cell = (Xmax - Xmin) / ncells;

	glPointSize(10);
	glColor3f(1, 0, 0);
	glBegin(GL_POINTS);
	glVertex2f(Xmin, Ymin);
	glVertex2f(Xmin, Ymax);
	glVertex2f(Xmax, Ymin);
	glVertex2f(Xmax, Ymax);
	glEnd();

	glColor3f(0.8, 0.8, 0.8);
	for (int i = 0; i < ncells; i++)
	{
		for (int j = 0; j < ncells; j++)
		{

			glBegin(GL_LINE_LOOP);
			glVertex2f(xi + cell*j, yi + cell*i);
			glVertex2f(xi + cell*(j + 1), yi + cell*i);
			glVertex2f(xi + cell*(j + 1), yi + cell*(i + 1));
			glVertex2f(xi + cell*j, yi + cell*(i + 1));
			glEnd();
		}
	}

}

void Shape::DrawPeaple() {
	//Desenha Face			
	//0.0, 0.0, 0.1875, 225	
	glColor3f(0, 0, 0);

	DesenhaCirculo(GL_LINE_LOOP, 100, 5, 1, 1, 5, 5);
	DesenhaCirculo(GL_POLYGON, 100, 5, 0.04, 0.04, 5.5, 5.3);
	DesenhaCirculo(GL_POLYGON, 100, 5, 0.04, 0.04, 4.5, 5.3);
	DesenhaSemiCirculo(GL_LINE_STRIP, 100, 5, 0.5, 0.5, 5, 4.8);

	//Desenha Corpo
	glColor3f(0, 0, 0);
	glBegin(GL_LINES);
	glVertex2f(5, 4);
	glVertex2f(5, 2);

	glVertex2f(5, 3);
	glVertex2f(5.5, 2);

	glVertex2f(5, 3);
	glVertex2f(4.5, 2);


	glVertex2f(5, 2);
	glVertex2f(5.5, 1);

	glVertex2f(5, 2);
	glVertex2f(4.5, 1);
	glEnd();


	//Desabilita o desenho do tipo de primitiva	
}


void Shape::DrawSpiral(float x, float y) {
	
	float raioX = 1;
	float raioY = 1;
	glColor3f(0, 0, 0);
	glBegin(GL_LINE_STRIP);
	for (int i = 0; i < 500; i++) {
		float angle = Pi*i / 30;
		raioX = raioX + 0.01;
		raioY = raioY + 0.01;
		glVertex2f(cos(angle)*raioX + x, sin(angle)*raioY + y);
	}
	glEnd();
}

void Shape::DesenhaCirculo(GLenum gl, float circle_points, float angle, float raioX, float raioY, float x, float y) {
	glColor3f(0, 0, 0);
	glBegin(gl);
	for (int i = 0; i < circle_points; i++) {
		angle = 2 * Pi*i / circle_points;
		glVertex2f(cos(angle)*raioX + x, sin(angle)*raioY + y);
	}
	glEnd();
}

void Shape::DesenhaSemiCirculo(GLenum gl, float circle_points, float angle, float raioX, float raioY, float x, float y) {
	glColor3f(0, 0, 0);
	glBegin(gl);
	for (int i = circle_points/2 ; i < circle_points; i++) {
		angle = 2 * Pi*i / circle_points;
		glVertex2f(cos(angle)*raioX + x, sin(angle)*raioY + y);
	}
	glEnd();
}

void Shape::DrawCirclePacman(GLenum gl, float circle_points, float angle, float raioX, float raioY, float x, float y) {
	glColor3f(0, 0, 0);
	glBegin(gl);
	float foo[2][2];
	for (int i = 30; i < circle_points -30; i++) {
		
		angle = 2 * Pi*i / circle_points;
		glVertex2f(cos(angle)*raioX + x, sin(angle)*raioY + y);
		if (i == 30)
		{
			foo[0][0] = cos(angle)*raioX + x;
			foo[0][1] = sin(angle)*raioY + y;
		}
		else {
			foo[1][0] = cos(angle)*raioX + x;
			foo[1][1] = sin(angle)*raioY + y;
		};
	}
	glEnd();

	glBegin(gl);
	glVertex2f(foo[0][0], foo[0][1]);
	glVertex2f(x, y);
	glVertex2f(foo[1][0], foo[1][1]);
	glEnd();

}



//
//void Shape::DrawCircle(float posX, float posY, float radius, float nPoints)
//{
//	float rd = radius;
//
//	float angle = 0.0;
//	float slice = 2 * Pi / nPoints;
//	float x, y;
//
//	float xi = posX;
//	float yi = posY;
//
//	//Habilitar a cor do círculo
//	glColor3f(0, 0, 0);
//
//	//Tamanho do ponto
//	glPointSize(5);
//
//	//Espessura da linha
//	glLineWidth(3);
//
//	//Habilitar o desenho do tipo de primitiva escolhido (ponto, linha, polígono etc)
//	glBegin(GL_POLYGON);
//	while (angle <= 2 * Pi)
//	{
//		//Sorteia uma cor para o vertice
//		float r = rand() % 10 / 10.0;
//		float b = rand() % 10 / 10.0;
//		float g = rand() % 10 / 10.0;
//
//		glColor3f(r, g, b);
//
//		//Calcular posicao do ponto em x, y
//		x = xi + rd * cos(angle);
//		y = yi + rd * sin(angle);
//		glVertex2f(x, y);
//		//Atualizar o angulo
//		angle += slice;
//	}
//	//Desabilita o desenho do tipo de primitiva
//	glEnd();
//
//	//Para desenhar o contorno
//	//Habilitar o desenho do tipo de primitiva escolhido (ponto, linha, polígono etc)
//	glColor3f(0, 0, 0);
//	angle = 0.0;
//	glBegin(GL_LINE_LOOP);
//	while (angle <= 2 * Pi)
//	{
//		//Calcular posicao do ponto em x, y
//		x = xi + rd * cos(angle);
//		y = yi + rd * sin(angle);
//		glVertex2f(x, y);
//		//Atualizar o angulo
//		angle += slice;
//	}
//	//Desabilita o desenho do tipo de primitiva
//	glEnd();
//
//	//Para desenhar os pontos
//	//Habilitar o desenho do tipo de primitiva escolhido (ponto, linha, polígono etc)
//	glColor3f(1, 0, 1);
//	angle = 0.0;
//	glBegin(GL_POINTS);
//	while (angle <= 2 * Pi)
//	{
//		//Calcular posicao do ponto em x, y
//		x = xi + rd * cos(angle);
//		y = yi + rd * sin(angle);
//		glVertex2f(x, y);
//		//Atualizar o angulo
//		angle += slice;
//	}
//	//Desabilita o desenho do tipo de primitiva
//	glEnd();
//
//}
//
//void Shape::DrawTriangle()
//{
//	glPointSize(15);
//	glLineWidth(3);
//
//	// Desenha um triângulo no centro da janela
//	glBegin(GL_TRIANGLES);
//	glColor3f(1, 0, 0);
//	glVertex2f(-0.5, -0.5);
//	glColor3f(0, 1, 0);
//	glVertex3f(0.0, 0.5, 0);
//	glColor3f(0, 0, 1);
//	glVertex3f(0.5, -0.5, 0);
//	glEnd();
//
//	glColor3f(0, 0, 0);
//	glBegin(GL_LINE_LOOP);
//	glVertex2f(-0.5, -0.5);
//	glVertex3f(0.0, 0.5, 0);
//	glVertex3f(0.5, -0.5, 0);
//	glEnd();
//
//	glColor3f(0, 1, 1);
//	glBegin(GL_POINTS);
//	glVertex2f(-0.5, -0.5);
//	glVertex3f(0.0, 0.5, 0);
//	glVertex3f(0.5, -0.5, 0);
//	glEnd();
//}
//
