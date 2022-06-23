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
    <td>54.677 em 0s</td>
    <td>11.660 em 1s</td>
    <td>257.416 em 11s</td>
    <td>1.023 em 2s</td>
    <td>65.142 em 5s</td>
    <td>67.796 em 5s</td>
    <td>234.897 em 2s</td>
    <td>3.116 em 5s</td>
    <td>1.398 em 2s</td>
  </tr>
  <tr>
    <td>10.000</td>
    <td>46.699 em 7s</td>
    <td>11.071 em 9s</td>
    <td>249.572 em 110s</td>
    <td>952 em 25s</td>
    <td>59.680 em 55s</td>
    <td>61.387 em 57s</td>
    <td>208.009 em 25s</td>
    <td>2.982 em 54s</td>
    <td>1.240 em 19s</td>
  </tr>
  <tr>
    <td>50.000</td>
    <td>49.921 em 47s</td>
    <td>10.466 em 551s</td>
    <td>243.353 em 551s</td>
    <td>959 em 127s</td>
    <td>60.887 em 276s</td>
    <td>58.343 em 281s</td>
    <td>203.717 em 122s</td>
    <td>2.819 em 274s</td>
    <td>1.304 em 95s</td>
  </tr>
  <tr>
    <td>100.000</td>
    <td>47.909 em 73s</td>
    <td>10.893 em 94s</td>
    <td>237.914 em 1084s</td>
    <td>884 em 257s</td>
    <td>57.660 em 571s</td>
    <td>51.887 em 611s</td>
    <td>212.802 em 269s</td>
    <td>2.611 em 592s</td>
    <td>1.234 em 207s/td>
  </tr>
</table>
  
