#include "Shapes.h"


void Shape::DrawPoligono(float lados){

	glColor3f(0, 0, 0);
	glBegin(GL_POLYGON);

	float x = 4, y = 4;
	for (int i = 0; i < lados; i++) {
		if(i % 2 == 0)
			glVertex2f(x + i -1, y +i -1);		
		else 
			glVertex2f(x + i, x +i);
	}
	glEnd();
}



void Shape::DrawPeaple() {
	//Desenha Face			
	//0.0, 0.0, 0.1875, 225	
	DesenhaCirculo(GL_LINE_LOOP,100, 5, 1, 1, 5,5);	
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


void Shape::DesenhaCirculo(GLenum gl,float circle_points, float angle, float raioX, float raioY, float x, float y) {	
	glBegin(gl);
	for (int i = 0; i < circle_points; i++) {
		angle = 2 * Pi*i / circle_points;
		glVertex2f(cos(angle)*raioX + x, sin(angle)*raioY+y);
	}
	glEnd();
}

void Shape::DesenhaSemiCirculo(GLenum gl, float circle_points, float angle, float raioX, float raioY, float x, float y) {
	glBegin(gl);
	for (int i = circle_points/2; i < circle_points ; i++) {
		angle = 2 * Pi*i / circle_points;
		glVertex2f(cos(angle)*raioX + x, sin(angle)*raioY + y);
	}
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
