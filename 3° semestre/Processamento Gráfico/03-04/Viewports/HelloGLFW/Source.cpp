//*****************************************************
//
// PrimeiroProjetoOpenGLGLFW
//
// Finalmente, removendo a GLUT da hist�ria :D
//
// Adaptado do projeto com GLUT por Rossana B. Queiroz 08/2011
// �ltima modifica��o: 03/05/2016
//*****************************************************

#include <cstdlib>
#include <iostream>
#include "Shapes.h" //� a Shapes que est� incluindo a glfw!

#define NVIEWPORTS 3  //vai gerar NVIEWPORTS x NVIEWPORTS, na verdade

using namespace std;

Shape shape; //objeto da classe shape

bool drawCircle = false; //flag para habilitar o desenho de c�rculos (apenas um exemplo)


//Prot�tipos de algumas fun��es (para n�o se preocupar com a ordem)
void ajustaCamera2D(int width, int height);


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
	if (key == GLFW_KEY_C && action == GLFW_PRESS)
	{
		drawCircle = !drawCircle;
	}
}

//Callback de redimensionamento
void reshape(GLFWwindow* window, int width, int height)
{
	// Prevent a divide by zero, when window is too short
	// (you cant make a window of zero width).
	if (height == 0)
		height = 1;

	ajustaCamera2D(width,height);

}

void ajustaCamera2D(int width, int height)
{
	//Ativa a matriz de proje��o --> conceitos mais tarde!!
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();

	if (width < height) //altura menor que largura
	{
		float aspecto = (float)height / width; //proporcao altura/largura 
		gluOrtho2D(Xmin, Xmax, Ymin*aspecto, Ymax*aspecto); //corrige a propor��o na largura
	}
	else {
		float aspecto = (float)width / height; //proporcao largura/altura
		gluOrtho2D(Xmin*aspecto, Xmax*aspecto, Ymin, Ymax); //corrige a propor��o na altura

	}
}

// Programa Principal 
int main(void)
{
	srand(time(0));

	//Inicializa��o da janela da aplica��o
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

	//Setando a callback de reshape
	glfwSetFramebufferSizeCallback(window, reshape);

	int width, height;
	float ratio;

	ajustaCamera2D(640, 480);

	while (!glfwWindowShouldClose(window)) //loop da aplica��o :)
	{	

		//aqui recupera o tamanho atual da janela
		glfwGetFramebufferSize(window, &width, &height);

		// Limpa a janela de visualiza��o com a cor branca
		glClearColor(1, 1, 1, 0);
		glClear(GL_COLOR_BUFFER_BIT);

		//seta a matriz de modelo 
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();


		for (int i = 0; i<NVIEWPORTS; i++) 
		{
			for (int j = 0; j<NVIEWPORTS; j++)
			{
				// Define a viewport
				glViewport(j*width/(float)NVIEWPORTS, i*height / (float)NVIEWPORTS, width / (float)NVIEWPORTS, height / (float)NVIEWPORTS);

				// Chamando as rotinas de desenho                        
				shape.DrawGrid();
				shape.DrawTriangle();
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
