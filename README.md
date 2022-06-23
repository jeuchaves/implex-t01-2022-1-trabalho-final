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
  
