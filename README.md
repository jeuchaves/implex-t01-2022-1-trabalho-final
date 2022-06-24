# Implex T01 2022-1 Trabalho Final

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
  
