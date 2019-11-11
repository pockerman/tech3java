package maths;

public interface IFunction<InputType, OutputType> {

    OutputType evaluate(InputType input);
}
