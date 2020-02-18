# Construindo interfaces gráficas

## Views

* São diversos elementos gráficos disponíveis para se montar a interface e receber interação com o usuário
  * outros nomes: controles, widgets


> * **TextView** - Exibe um de texto formatado
> * **ImageView** - Exibe uma imagem
> * **Button** - É utilizado para e executar uma ação ao ser clicado
> * **ImageButton** - Exibe uma imagem com comportamento de um botão
> * **EditText** - É um campo de texto editável para a entrada de dados
> * **ListView** - É uma lista de itens que contém outras Views

## Gerenciador de Layout

* Um objeto gráfico do Android, que tem por objetivo definir e organizar como os outros objetos gráficos (as outras Views da sua interface) vão aparecer na tela.
* Funciona a partir de "regras" que definem onde os elementos devem ficar.
* Com base nessas regras, o Android toma conta do tamanho da tela, densidade (de pixels) da tela e das Views, e outros fatores de forma a posicioná-los na tela adequadamente.
* o Android possui vários gerenciadores de layout, cada um com objetivos específicos:
  * LinearLayout
  * RelativeLayout
  * FrameLayout
  * TableLayout
  * ConstraintLayout

### Alguns termos para definir tamanhos...

* **wrap_content**
  * A view vai ter o tamanho suficiente para envolter seu conteúdo.
* **match_constraint**
  * A view deve corresponder ao que a restrição diz.
* **valor exato**
  * preferenciamente dp (density independent pixels).

## Constraint Layout

* Restrições, Limitações
* Configuração de "limites" que as views tem que respeitar
* Tamanho da "view"
  * wrap_content
  * match_constraint
  * fixed
* **Pelos menos:**
  * Uma referência vertical
  * Uma referência horizontal
  * Sem alguma delas, vai para o default (topo, esquerda)