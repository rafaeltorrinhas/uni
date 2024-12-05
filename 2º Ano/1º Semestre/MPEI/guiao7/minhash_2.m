function MA = minhash_2(Shingles, nhf, R, p)
   
    % Number of sets (words) in the input
    num_sets = length(Shingles);

    % Initialize the MinHash signature matrix with Inf values
    MA = Inf(nhf, num_sets); 

    % Loop over each set of shingles (each word's shingles)
    for i = 1:num_sets
        % Get the shingles for the current word
        shingles_list = Shingles{i};
        
        % If there are no shingles, skip this word
        if isempty(shingles_list)
            continue;
        end
        
        % Loop over each hash function
        for hf = 1:nhf
            % Loop over all shingles in the current set (word)
            for j = 1:length(shingles_list)
                shingle = shingles_list{j};  % Current shingle

                % Compute the hash value for the current shingle and hash function
                hc = hash_function_shingle(shingle, hf, R, p);
                
                % Update the MinHash signature matrix with the minimum hash value
                MA(hf, i) = min(MA(hf, i), hc);
            end
        end
    end
end
