/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.api.merge.type;

import com.alee.api.merge.Merge;
import com.alee.api.merge.MergePolicy;
import com.alee.utils.CollectionUtils;

import java.util.HashSet;

/**
 * Restricts merge to objects of the specified types only.
 *
 * @author Mikle Garin
 * @see <a href="https://github.com/mgarin/weblaf/wiki/How-to-use-Merge">How to use Merge</a>
 * @see Merge
 */

public class SpecificTypesMergePolicy implements MergePolicy
{
    /**
     * Accepted object types.
     */
    private final HashSet<Class<?>> types;

    /**
     * Constructs new {@link SpecificTypesMergePolicy}.
     *
     * @param types accepted object types
     */
    public SpecificTypesMergePolicy ( final Class<?>... types )
    {
        this ( CollectionUtils.asHashSet ( types ) );
    }

    /**
     * Constructs new {@link SpecificTypesMergePolicy}.
     *
     * @param types accepted object types
     */
    public SpecificTypesMergePolicy ( final HashSet<Class<?>> types )
    {
        super ();
        this.types = types;
    }

    @Override
    public boolean accept ( final Merge merge, final Object object, final Object merged )
    {
        return types.contains ( object.getClass () ) && types.contains ( merged.getClass () );
    }
}