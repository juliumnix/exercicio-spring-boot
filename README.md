# exercicio-spring-boot
O exercicio em questão está presente na página 125 da apostila

Alguns pontos a ressaltar da implementação
--
- primeiramente a ideia do exercicio era gerar as 3 entidades em separado. Fiquei um pouco em dúvida uma vez que não havia nenhum relacionamento entre elas, então todas as classes de entidade seriam "individuais".
- outro ponto a ressaltar, durante a aula o professor orientou que caso essas 3 entidades fossem criadas, seus métodos de `GET`, `POST`, `"GET ALL"`, `"GET By ID"` e `DELETE`, poderia ser criado uma nova entidade chamada venda, e essa criaria uma venda, de acordo com os dados pré criados.
- minha ideia geral, foi conectar as entidades `produto` e `fornecedor`, pois "um ou vários produto deve ter um fornecedor", em seguida conectar o `cliente` e o `produto` a nova entidade `venda`.
- outra parte do exercicio, foi os métodos de criar e buscar as vendas. Por motivos de querer buscar e apresentar o nome do fornecedor, e também o nome do produto, de acordo com o id do cliente, criei um objeto `DTO`, que é responsável por criar essas visualização personalizada.
