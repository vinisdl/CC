using System;
using System.Collections.Generic;
using System.Linq;

namespace SistemasOperacionais
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("                         ``                       ");
            Console.WriteLine("                      :;;::'':                    ");
            Console.WriteLine("                    `',`....`;'.                  ");
            Console.WriteLine("                   `'`........,'.                 ");
            Console.WriteLine("                   '...,,,,,,,,:'`                ");
            Console.WriteLine("                  ;:,,,,,,,,,,:,+;                ");
            Console.WriteLine("                  ',,,,,,::::::::+`               ");
            Console.WriteLine("                 ;',:::::::::::::#;               ");
            Console.WriteLine("                 '::@,,+;::;;;;;;+'               ");
            Console.WriteLine("                .+:#:@@+;;;;;;;;;'+,              ");
            Console.WriteLine("                ;#+;+``.@@;'@+'@''#;              ");
            Console.WriteLine("                '#'@,.`..+'@'@#;#+#'              ");
            Console.WriteLine("                '#',...`.##@:``;+@@+`             ");
            Console.WriteLine("               `+@#,.```.,@,..`.,+@+.             ");
            Console.WriteLine("               ,+@@..```',+..```.#@#:             ");
            Console.WriteLine("               :#@#.````@;':````.:@#;             ");
            Console.WriteLine("               ;#@+,```,@#@,````.,@#'             ");
            Console.WriteLine("               '#@#,```.@@@@````.,@#'             ");
            Console.WriteLine("               '#@@,.```+++@````.;@#'             ");
            Console.WriteLine("               '#@@,.```.,#,.`...@@@'             ");
            Console.WriteLine("               +@@@:,..,``.,,.``'@@@+             ");
            Console.WriteLine("               +@@@@...:``.,,,,@@@@@+`            ");
            Console.WriteLine("              ,#@@@@#.`::,.,,:.@@@@@#:            ");
            Console.WriteLine("              ;#@@@@`,:::::,,,``@@@@#'            ");
            Console.WriteLine("             .,@@@@```..::,::.`` @@@@',           ");
            Console.WriteLine("             ::@@@+````,,:::,.```;@@@'.           ");
            Console.WriteLine("            ,,'@@@`````.,:::.`````@@@#.:          ");
            Console.WriteLine("            ,:#@@+``````,,:,.`````;@@@,,`         ");
            Console.WriteLine("           ::'@@@```````....```````@@@':,         ");
            Console.WriteLine("          ;:'@@@@`````````.````````#@@@'::        ");
            Console.WriteLine("         ::'@@@@;``````````````````,@@@@+::       ");
            Console.WriteLine("        `:'##@@@````````````````````@@@##':.      ");
            Console.WriteLine("        :;++##@@````````````````````@@##++;:      ");
            Console.WriteLine("       `:+';`#@@....................#@#`;'+;.     ");
            Console.WriteLine("       ,;;`  +@#....................+@+   ;;,     ");
            Console.WriteLine("       .:    '#'....................:#+    ,,     ");
            Console.WriteLine("             '#:....................,#'           ");
            Console.WriteLine("             :#,....................,#:           ");
            Console.WriteLine("             :#,.....................#:           ");
            Console.WriteLine("             ,:,.....................::           ");
            Console.WriteLine("              ,,,,,,,,,,,,,,,,,,,,,,,:`           ");
            Console.WriteLine("              :.,,,,,,,,,,,,,,,,,,,,.:            ");
            Console.WriteLine("              :,.,,,,,,,,,,,,,,,,,,.,;            ");
            Console.WriteLine("               :.:::,,,,,,,,,,,,::,,:`            ");
            Console.WriteLine("               ':;;;;:,,,,,,,,:;;;;:'             ");
            Console.WriteLine("               ,:;:::;::,,,,,:;;::;:,             ");
            Console.WriteLine("              ,,```.::;:,,,,:;::,```.,            ");
            Console.WriteLine("             ..`````,::;:,,:;:::``````,           ");
            Console.WriteLine("            `,.......::::,,::::.......,.          ");
            Console.WriteLine("            ,,.......:::;,,;:::........,          ");
            Console.WriteLine("            ,,,,,...,:::;:,;:::....,,,,:.         ");
            Console.WriteLine("          `.::,,,,,,,:::;::;;:::,,,,,,,:,`        ");
            Console.WriteLine("         ``,:;:::::::::;;::;;;:::::::::::`        ");
            Console.WriteLine("         `.,:;;::::::;;;;'';;;;::::::;;:,.`       ");
            Console.WriteLine("         `.,::;;;;;;;;;'''''';;;;;;;;:::,.`       ");
            Console.WriteLine("         ``..,,,,,::::::;;;;::::::,,,,,..`        ");
            Console.WriteLine("           ````........,,,,,,.......`````         ");
            Console.WriteLine("                  ````````````````                ");
            Console.WriteLine("                                                  ");
            Console.WriteLine("                                                  ");
            Console.WriteLine("                                                  ");
            Console.WriteLine("                                                  ");
            Console.WriteLine("                                                  ");
            Console.WriteLine("                                                  ");

            Console.WriteLine("");
            Console.WriteLine("");
            Console.WriteLine("");
            Console.WriteLine("Digite os valores de entrata no formato nome,ciclos,tipo");
            var input = Console.ReadLine();
            var processos = new List<Processo>();

            var count = 1;
            while (!input.Equals("X"))
            {
                var dados = input.Split(',');

                try
                {
                    var processo = new Processo
                    {
                        Nome = dados[0],
                        Ciclos = Int32.Parse(dados[1]),
                        Tipo = (Tipo)Enum.Parse(typeof(Tipo), dados[2]),
                    };
                    if (processos.Select(a => a.Nome).Contains(processo.Nome))
                        Console.WriteLine("Ja existe um processo com este nome.");
                    else
                    {
                        processo.Num = count;
                        processos.Add(processo);
                        count++;
                    }
                }
                catch (Exception e)
                {
                    Console.WriteLine("Dados em formato incorreto");
                }

                Console.WriteLine();
                Console.WriteLine();
                Console.WriteLine("Digite os novos dados ou X para sair:");
                input = Console.ReadLine();

            }

            processos.Add(new Processo
            {
                Nome = "A",
                Ciclos = 170,
                Tipo = Tipo.C,
                Num = 1
            });
            processos.Add(new Processo
            {
                Nome = "B",
                Ciclos = 25,
                Tipo = Tipo.C,
                Num = 2
            });
            processos.Add(new Processo
            {
                Nome = "C",
                Ciclos = 1000,
                Tipo = Tipo.C,
                Num = 3
            });
            processos.Add(new Processo
            {
                Nome = "D",
                Ciclos = 50,
                Tipo = Tipo.I,
                Num = 4
            });
            processos.Add(new Processo
            {
                Nome = "E",
                Ciclos = 35,
                Tipo = Tipo.I,
                Num = 5
            });

            processos.Add(new Processo
            {
                Nome = "F",
                Ciclos = 200,
                Tipo = Tipo.I,
                Num = 6
            });

            processos.Add(new Processo
            {
                Nome = "G",
                Ciclos = 200,
                Tipo = Tipo.I,
                Num = 7
            });


            processos = OrderList(processos);
            while (processos.Select(a => a.Ciclos).Sum() > 0)
            {
                foreach (var processo in processos)
                {
                    if (processo.Tipo == Tipo.I)
                    {
                        ProcessaIO(processo);
                    }
                    else
                    {
                        ProcessaCPU(processo);
                    }

                }
            }
            Console.ReadLine();
        }


        public static void ProcessaCPU(Processo processo)
        {
            var bound = 0;
            while (bound < 200 && processo.Ciclos > 0)
            {
                processo.Ciclos--;
                bound++;
            }
            if (bound > 0)
                Console.WriteLine(string.Format("CICLO NUMERO: {0}, PROCESSO {1} DO TIPO {3} EXECUTOU POR UNIDADES {2} DE TEMPO", processo.Num, processo.Nome, bound, processo.Tipo));

        }


        public static void ProcessaIO(Processo processo)
        {
            var bound = 0;
            while (bound < 100 && processo.Ciclos > 0)
            {
                processo.Ciclos--;
                bound++;
            }
            if (bound > 0)
                Console.WriteLine(string.Format("CICLO NUMERO: {0}, PROCESSO {1}  DO TIPO {3} EXECUTOU POR UNIDADES {2} DE TEMPO", processo.Num, processo.Nome, bound, processo.Tipo));
        }

        public static double Percent(double percent, int total)
        {
            return percent / total;
        }

        public static List<Processo> OrderList(List<Processo> processos)
        {
            var Io = processos.Where(a => a.Tipo == Tipo.I);
            var Cpu = processos.Where(a => a.Tipo == Tipo.C);

            var percentIo = (int)( (Percent(Io.Count(), processos.Count()) * processos.Count())) ;
            var percentCpu = (int)(Percent(Cpu.Count(), processos.Count())* processos.Count()) ;

            // 80% I
            // 20% C     

            var temp = new List<Processo>();
            var tem = true;
            while (tem)
            {

                temp.AddRange(processos.Where(a => a.Tipo == Tipo.I).Take(percentIo)); 
                temp.AddRange(processos.Where(a=>a.Tipo == Tipo.C).Take(percentCpu));
                temp.ForEach(a => processos.Remove(a));

                if (processos.Count == 0)
                    tem = false;
            }
            return temp;
        }
    }
    class Processo
    {
        public int Num { get; set; }
        public string Nome { get; set; }
        public int Ciclos { get; set; }
        public Tipo Tipo { get; set; }
    }

    public enum Tipo
    {
        C,
        I
    }


}