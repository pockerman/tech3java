package datastructs.maths;

import datastructs.interfaces.IRowBuilder;
import datastructs.utils.RowType;

import java.util.HashMap;
import java.util.Map;

public class RowBuilder {


    private static Map<RowType.Type, IRowBuilder<?>> elementBuilder = new HashMap<>();

    static
    {
        elementBuilder.put(RowType.Type.VECTOR, new VectorBuilder());
    }

    <Row> Row build(RowType.Type type){

        return (Row) elementBuilder.get(type).create();
    }

    <Row> Row build(RowType.Type type, int n){

        return (Row) elementBuilder.get(type).create(n);
    }

    <Row, T> Row build(RowType.Type type, T... vals){

        return (Row) elementBuilder.get(type).create( vals);
    }

}
