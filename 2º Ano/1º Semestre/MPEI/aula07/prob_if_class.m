function [p_class] = prob_if_class(class, classes, X)
    class_lines = strcmp(classes, class);
    class_matrix = X(class_lines, :);
    class_occurence = sum(class_matrix) + 1;

    tot = sum(class_matrix, "all") + size(X, 2);

    p_class = class_occurence / tot;
end