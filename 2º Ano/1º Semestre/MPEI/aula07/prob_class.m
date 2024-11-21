function [p] = prob_class(movie, p_aspect_if_class, p_class)
    p = 1;

    for i = 1:length(p_aspect_if_class)

        if movie(i) ~= 0
            p = p * p_aspect_if_class(i);
        end

    end
    p = p * p_class;
end