# Implex T01 2022-1 Trabalho Final

## Detalhes da Implementação

### Calcular distância
A distância euclidiana é calculada pela fórmula:

![distancia-euclidiana](https://user-images.githubusercontent.com/81452517/175548824-2f0b5e79-71aa-47b3-a61c-0ce81db39710.png)

### Melhores soluções conhecidas para os arquivos:
<table>
  <tr>
    <th>att48</th>
    <th>berlin52</th>
    <th>bier127</th>
    <th>eil76</th>
    <th>kroA100</th>
    <th>kroE100</th>
    <th>pr76</th>
    <th>rat99</th>
    <th>st70</th>
  </tr>
  <tr>
    <th>10.628</th>
    <th>7.542</th>
    <th>118.282</th>
    <th>538</th>
    <th>21.282</th>
    <th>22.068</th>
    <th>108.159</th>
    <th>1.211</th>
    <th>675</th>
  </tr>
</table>

### Casos de estudo para o Simulated Annealing:

<table>
  <tr>
    <th>Casos</th>
    <th>Tmax</th>
    <th>k</th>
    <th>Kt</th>
    <th>Tmin</th>
  </tr>
  <tr>
    <th>A</th>
    <th>10</th>
    <th>0.95</th>
    <th>20</th>
    <th>5</th>
  </tr>
  <tr>
    <th>B</th>
    <th>100</th>
    <th>0.9</th>
    <th>25</th>
    <th>10</th>
  </tr>
  <tr>
    <th>C</th>
    <th>*</th>
    <th>*</th>
    <th>*</th>
    <th>*</th>
  </tr>
</table>

### Encontrar Vizinhança

A vizinhança da solução corrente vc será obtida pelo mapeamento 2-troca em que duas
arestas não adjacentes são trocadas. A geração de um vizinho de uma solução corrente
SolucaoCorrente, trocando as arestas i?1, i e k, k + 1 

## Detalhes de Entrega

- Os códigos fontes de cada implementação
- Um arquivo readme com as instruções de compilação e execução
- Um relatório sucinto contendo:
  - A descrição de uma aplicação do TSP, e
  - Os resultados encontrados comparados com os melhores resultados existentes para as instâncias fornecidas
  
## Descrição

O Problema do Caixeiro Viajante (PCV) é um problema que tenta determinar a menor rota para percorrer uma série de cidades (visitando uma única vez cada uma delas), retornando à cidade de origem. Ele é um problema de otimização NP-difícil inspirado na necessidade dos vendedores em realizar entregas em diversos locais (as cidades) percorrendo o menor caminho possível, reduzindo o tempo necessário para a viagem e os possíveis custos com transporte e combustível.

## Resultados

### Hill-Climb

#### Versão 1.0

##### Relatório sobre o programa: 22/06/2022 às 01h41
Essa versão apresenta um problema onde independentemente da quantidade de interações escolhida ele apresenta o mesmo resultado. Assim que solucionar o problema apresentarei uma nova versão corrigida. 

<table>
  <tr>
    <th>Quantidade de Interações</th>
    <th>att48</th>
    <th>berlin52</th>
    <th>bier127</th>
    <th>eil76</th>
    <th>kroA100</th>
    <th>kroE100</th>
    <th>pr76</th>
    <th>rat99</th>
    <th>st70</th>
  </tr>
  <tr>
    <td>10.000</td>
    <td>153.762</td>
    <td>20.966</td>
    <td>387.330</td>
    <td>1.926</td>
    <td>188.706</td>
    <td>184.805</td>
    <td>147.041</td>
    <td>1.878</td>
    <td>3.359</td>
  </tr>
</table>

#### Versão 1.1

##### Relatório sobre o programa: 22/06/2022 às 19h17
O bug consistia em duas partes do código: A primeira era na função calcularDistancia() onde não estava relacionando com o caminho selecionado, mas sim com a lista de posições. O segundo problema era que não estava sendo armazenado a distancia do vizinho com melhor caminho.

<table>
  <tr>
    <th>Quantidade de Interações</th>
    <th>att48</th>
    <th>berlin52</th>
    <th>bier127</th>
    <th>eil76</th>
    <th>kroA100</th>
    <th>kroE100</th>
    <th>pr76</th>
    <th>rat99</th>
    <th>st70</th>
  </tr>
  <tr>
    <td>1.000</td>
    <td>54.677</td>
    <td>11.660</td>
    <td>257.416</td>
    <td>1.023</td>
    <td>65.142</td>
    <td>67.796</td>
    <td>234.897</td>
    <td>3.116</td>
    <td>1.398</td>
  </tr>
  <tr>
    <td>10.000</td>
    <td>46.699</td>
    <td>11.071</td>
    <td>249.572</td>
    <td>952</td>
    <td>59.680</td>
    <td>61.387</td>
    <td>208.009</td>
    <td>2.982</td>
    <td>1.240</td>
  </tr>
  <tr>
    <td>50.000</td>
    <td>49.921</td>
    <td>10.466</td>
    <td>243.353</td>
    <td>959</td>
    <td>60.887</td>
    <td>58.343</td>
    <td>203.717</td>
    <td>2.819</td>
    <td>1.304</td>
  </tr>
  <tr>
    <td>100.000</td>
    <td>47.909</td>
    <td>10.893</td>
    <td>237.914</td>
    <td>884</td>
    <td>57.660</td>
    <td>51.887</td>
    <td>212.802</td>
    <td>2.611</td>
    <td>1.234</td>
  </tr>
</table>

<table>
  <tr>
    <th>Quantidade de Interações</th>
    <th>att48</th>
    <th>berlin52</th>
    <th>bier127</th>
    <th>eil76</th>
    <th>kroA100</th>
    <th>kroE100</th>
    <th>pr76</th>
    <th>rat99</th>
    <th>st70</th>
  </tr>
  <tr>
    <td>1.000</td>
    <td>0s</td>
    <td>1s</td>
    <td>11s</td>
    <td>2s</td>
    <td>5s</td>
    <td>5s</td>
    <td>2s</td>
    <td>5s</td>
    <td>2s</td>
  </tr>
  <tr>
    <td>10.000</td>
    <td>7s</td>
    <td>9s</td>
    <td>110s</td>
    <td>25s</td>
    <td>55s</td>
    <td>57s</td>
    <td>25s</td>
    <td>54s</td>
    <td>19s</td>
  </tr>
  <tr>
    <td>50.000</td>
    <td>47s</td>
    <td>551s</td>
    <td>551s</td>
    <td>127s</td>
    <td>276s</td>
    <td>281s</td>
    <td>122s</td>
    <td>274s</td>
    <td>95s</td>
  </tr>
  <tr>
    <td>100.000</td>
    <td>73s</td>
    <td>94s</td>
    <td>1084s</td>
    <td>257s</td>
    <td>571s</td>
    <td>611s</td>
    <td>269s</td>
    <td>592s</td>
    <td>207s</td>
  </tr>
</table>

#### Versão 1.2

##### Relatório sobre o programa: 24/06/2022 às 09h26
Como ainda não tinha a fórmula para geração de vizinhos do trabalho eu realizei um método diferente nas versões anteriores para isso. No entanto, essa versão conta com os resultados da geração de vizinhos requisitada pelo professor

<table>
  <tr>
    <th>Quantidade de Interações</th>
    <th>att48</th>
    <th>berlin52</th>
    <th>bier127</th>
    <th>eil76</th>
    <th>kroA100</th>
    <th>kroE100</th>
    <th>pr76</th>
    <th>rat99</th>
    <th>st70</th>
  </tr>
  <tr>
    <td>1.000</td>
    <td>83.642</td>
    <td>18.627</td>
    <td>432.599</td>
    <td>1.570</td>
    <td>102.274</td>
    <td>99.654</td>
    <td>354.143</td>
    <td>4.780</td>
    <td>2.200</td>
  </tr>
  <tr>
    <td>10.000</td>
    <td>79.464</td>
    <td>17.052</td>
    <td>411.684</td>
    <td>1.471</td>
    <td>97.772</td>
    <td>98.249</td>
    <td>344.527</td>
    <td>4.710</td>
    <td>2.127</td>
  </tr>
  <tr>
    <td>50.000</td>
    <td>76.356</td>
    <td>16.792</td>
    <td>408.008</td>
    <td>1.449</td>
    <td>95.252</td>
    <td>96.407</td>
    <td>326.815</td>
    <td>4.592</td>
    <td>2.038</td>
  </tr>
  <tr>
    <td>100.000</td>
    <td>73.759</td>
    <td>16.402</td>
    <td>411.590</td>
    <td>1.456</td>
    <td>92.984</td>
    <td>92.413</td>
    <td>335.431</td>
    <td>4.548</td>
    <td>2.003</td>
  </tr>
</table>

<table>
  <tr>
    <th>Quantidade de Interações</th>
    <th>att48</th>
    <th>berlin52</th>
    <th>bier127</th>
    <th>eil76</th>
    <th>kroA100</th>
    <th>kroE100</th>
    <th>pr76</th>
    <th>rat99</th>
    <th>st70</th>
  </tr>
  <tr>
    <td>1.000</td>
    <td>0s</td>
    <td>0s</td>
    <td>11s</td>
    <td>2s</td>
    <td>5s</td>
    <td>5s</td>
    <td>2s</td>
    <td>5s</td>
    <td>1s</td>
  </tr>
  <tr>
    <td>10.000</td>
    <td>6s</td>
    <td>7s</td>
    <td>109s</td>
    <td>22s</td>
    <td>54s</td>
    <td>54s</td>
    <td>23s</td>
    <td>51s</td>
    <td>17s</td>
  </tr>
  <tr>
    <td>50.000</td>
    <td>30s</td>
    <td>37s</td>
    <td>547s</td>
    <td>109s</td>
    <td>271s</td>
    <td>270s</td>
    <td>114s</td>
    <td>254s</td>
    <td>86s</td>
  </tr>
  <tr>
    <td>100.000</td>
    <td>60s</td>
    <td>75s</td>
    <td>1094s</td>
    <td>219s</td>
    <td>542s</td>
    <td>540s</td>
    <td>229s</td>
    <td>509s</td>
    <td>173s</td>
  </tr>
</table>

### Simulated Annealing

#### Versão 1.0

##### Relatório sobre o programa: 27/06/2022 às 22h03
Essa versão apresenta um problema onde os resultados obtidos demoram muito pouco tempo para serem gerados (próximo dos 0s).
<br>Caso C -> Temperatura máxima: 100; Razão de esfriamento: 0.8; Quantidade de iterações: 20; Temperatura minima: 5;

<table>
  <tr>
    <th>Caso</th>
    <th>att48</th>
    <th>berlin52</th>
    <th>bier127</th>
    <th>eil76</th>
    <th>kroA100</th>
    <th>kroE100</th>
    <th>pr76</th>
    <th>rat99</th>
    <th>st70</th>
  </tr>
  <tr>
    <td>A</td>
    <td>131.153</td>
    <td>27.849</td>
    <td>603.251</td>
    <td>2.141</td>
    <td>179.198</td>
    <td>178.248</td>
    <td>582.606</td>
    <td>7.629</td>
    <td>3.701</td>
  </tr>
  <tr>
    <td>B</td>
    <td>171.399</td>
    <td>31.140</td>
    <td>641.302</td>
    <td>2.407</td>
    <td>164.667</td>
    <td>170.307</td>
    <td>591.350</td>
    <td>8.344</td>
    <td>3.556</td>
  </tr>
  <tr>
    <td>C</td>
    <td>163.050</td>
    <td>32.306</td>
    <td>675.355</td>
    <td>2.441</td>
    <td>193.988</td>
    <td>167.701</td>
    <td>581.040</td>
    <td>8.221</td>
    <td>3.585</td>
  </tr>
</table>

#### Versão 1.1

##### Relatório sobre o programa: 27/06/2022 às 22h27
Problema resolvido, o algoritmo não fazia a leitura da quantida de iteracoes e acabava não entrando no laço.
<br>Caso C -> Temperatura máxima: 10000; Razão de esfriamento: 0.99; Quantidade de iterações: 1000; Temperatura minima: 5;

<table>
  <tr>
    <th>Caso</th>
    <th>att48</th>
    <th>berlin52</th>
    <th>bier127</th>
    <th>eil76</th>
    <th>kroA100</th>
    <th>kroE100</th>
    <th>pr76</th>
    <th>rat99</th>
    <th>st70</th>
  </tr>
  <tr>
    <td>A</td>
    <td>130.476</td>
    <td>22.146 </td>
    <td>511.359</td>
    <td>1.946</td>
    <td>124.030</td>
    <td>136.167</td>
    <td>444.228</td>
    <td>6.227</td>
    <td>2.826</td>
  </tr>
  <tr>
    <td>B</td>
    <td>94.762</td>
    <td>20.263</td>
    <td>527.773</td>
    <td>1.884</td>
    <td>122.802</td>
    <td>148.251</td>
    <td>436.661</td>
    <td>6.437</td>
    <td>2.736</td>
  </tr>
  <tr>
    <td>C</td>
    <td>127.195</td>
    <td>21.336</td>
    <td>513.680</td>
    <td>1.873</td>
    <td>140.256</td>
    <td>128.621</td>
    <td>441.842</td>
    <td>5.879</td>
    <td>2.656</td>
  </tr>
</table>

Resultados do caso C com alterações: 

<table>
  <tr>
    <th>Caso</th>
    <th>att48</th>
    <th>berlin52</th>
    <th>bier127</th>
    <th>eil76</th>
    <th>kroA100</th>
    <th>kroE100</th>
    <th>pr76</th>
    <th>rat99</th>
    <th>st70</th>
  </tr>
  <tr>
    <td>Tmax: 100; Tmin: 50; R: 0.96; T: 7000</td>
    <td>130434</td>
    <td>26887</td>
    <td>498617</td>
    <td>1998</td>
    <td>130619</td>
    <td>132640</td>
    <td>371713</td>
    <td>5750</td>
    <td>2692</td>
  </tr>
  <tr>
    <td>Tmax: 10000; Tmin: 10; R: 0.5; T: 10000</td>
    <td>94.762</td>
    <td>20.263</td>
    <td>527.773</td>
    <td>1.884</td>
    <td>122.802</td>
    <td>148.251</td>
    <td>436.661</td>
    <td>6.437</td>
    <td>2.736</td>
  </tr>
  <tr>
    <td>Tmax: 10000; Tmin: 10; R: 0.5; T: 10000</td>
    <td>114.582</td>
    <td>23.419</td>
    <td>495.219</td>
    <td>1.981</td>
    <td>115.480</td>
    <td>124.655</td>
    <td>457.721</td>
    <td>6.203</td>
    <td>2.725</td>
  </tr>
</table>
