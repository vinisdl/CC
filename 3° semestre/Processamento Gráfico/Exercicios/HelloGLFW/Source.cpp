//*****************************************************
//
// PrimeiroProjetoOpenGLGLFW
//
// Finalmente, removendo a GLUT da história :D
//
// Adaptado do projeto com GLUT por Rossana B. Queiroz 08/2011
// Última modificação: 03/05/2016
//*****************************************************

#include <cstdlib>
#include <iostream>
#include "Shapes.h" //é a Shapes que está incluindo a glfw!

using namespace std;

Shape shape; //objeto da classe shape
#define NVIEWPORTS 2  //vai gerar NVIEWPORTS x NVIEWPORTS, na verdade

bool drawCircle = false; //flag para habilitar o desenho de círculos (apenas um exemplo)

float selectKey;
//Callback de erro 
static void error_callback(int error, const char* description)
{
	fputs(description, stderr);
}

//Callback de teclado
static void key_callback(GLFWwindow* window, int key, int scancode, int action, int mods)
{
	if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS)
		glfwSetWindowShouldClose(window, GL_TRUE);

	selectKey = key;

	if (key == 265) {
		constant++;
		selectKey = 51;
	}
	else
		if (key == 264) {
			constant--;
			selectKey = 51;
		}
}


// Programa Principal 
int main(void)
{
	srand(time(0));

	//Inicialização da janela da aplicação
	GLFWwindow* window;

	//Setando a callback de erro
	glfwSetErrorCallback(error_callback);

	//Inicializando a lib
	if (!glfwInit())
		exit(EXIT_FAILURE);

	//Criando a janela
	window = glfwCreateWindow(640, 480, "HELLO GLFW!! BYE BYE GLUT!!!", NULL, NULL);
	if (!window)
	{
		glfwTerminate();
		exit(EXIT_FAILURE);
	}

	//Colocando a janela criada como sendo o contexto atual
	glfwMakeContextCurrent(window);
	glfwSwapInterval(1);

	//Setando a callback de teclado
	glfwSetKeyCallback(window, key_callback);

	while (!glfwWindowShouldClose(window)) //loop da aplicação :)
	{
		int width, height;

		//aqui recupera o tamanho atual da janela, para correção do aspect ratio mais tarde
		glfwGetFramebufferSize(window, &width, &height);

		//setando a viewport da OpenGL, para ocupar toda a janela da aplicação
		glViewport(0, 0, width, height);

		// Limpa a janela de visualização com a cor branca
		glClearColor(1, 1, 1, 0);
		glClear(GL_COLOR_BUFFER_BIT);

		//Setando a matriz de projeção, para definir o Ortho (câmera ortográfica 2D)
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();

		//Setando a janela do mundo a ser vista (window), a câmera ortográfica 2D
		if (width >= height) {
			float ac = (float)width / height; //proporcao altura/largura 
			gluOrtho2D(0, 10 * ac, 0, 10);
		}
		else {
			float ac = (float)width / height; //proporcao altura/largura 
			gluOrtho2D(0, 10, 0, 10 * ac);
		}


		//Trocando para a matriz de modelo
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();


		for (int i = 0; i<NVIEWPORTS; i++)
		{
			for (int j = 0; j<NVIEWPORTS; j++)
			{
				// Define a viewport
				glViewport(j*width / (float)NVIEWPORTS, i*height / (float)NVIEWPORTS, width / (float)NVIEWPORTS, height / (float)NVIEWPORTS);

				// Chamando as rotinas de desenho                        
				shape.DrawGrid();



				if (selectKey == 49)
					shape.DrawPoligono(3, true, constant);
				else if (selectKey == 50)
					shape.DrawPoligono(4, true, constant);
				else if (selectKey == 51)
					shape.DrawPoligono(4, false, constant);
				else if (selectKey == 52)
					shape.DrawPoligono(6, true, constant);
				else if (selectKey == 53)
					shape.DrawLosango();
				else if (selectKey == 54)
					shape.DesenhaCirculo(GL_LINE_LOOP, 100, 5, 1, 1, 5, 5);
				else if (selectKey == 55)
					shape.DesenhaCirculo(GL_LINE_LOOP, 100, 5, 1, 3, 3, 5);
				else if (selectKey == 56)
					shape.DrawSpiral(4, 5);
				else if (selectKey == 57) {
					shape.DesenhaSemiCirculo(GL_LINE_STRIP, 30, 40, 1.5, 0.6, 5, 4.8);
					glBegin(GL_LINE_STRIP);
					glVertex2f(3.5, 4.8);
					glVertex2f(5, 7);
					glVertex2f(6.5, 4.6);
					glEnd();
				}
				else if (selectKey == 48)
				{
					shape.DrawCirclePacman(GL_LINE_STRIP, 400, 40, -3, 4, 5, 5);
				}
				else if (selectKey == 80)
					shape.DrawPeaple();
			}
		}








		glfwSwapBuffers(window);
		glfwPollEvents();
	}

	glfwDestroyWindow(window);

	glfwTerminate();
	exit(EXIT_SUCCESS);

	return 0;
}
