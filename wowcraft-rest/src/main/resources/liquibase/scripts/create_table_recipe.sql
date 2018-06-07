create table recipe (
  id integer auto_increment primary key ,
  name nvarchar(100) not null
);

create table recipe_reagent (
  id integer auto_increment primary key,
  recipe_id integer not null,
  reagent_id integer not null,
  count integer not null,

  constraint fk_recipe foreign key (recipe_id) references recipe(id),
  constraint fk_reagent foreign key (recipe_id) references reagents(id)
);

